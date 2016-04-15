<?php
/*
Recupere le json passe en parametre GET["json"]
Effectue la requete SQL correspondante
Renvoie un JSON de la forme : 
{
	"1":{
		"id":"2706028558",
		"latitude":"45.4296",
		"longitude":"4.3825",
		"distance":"998.1251658034142",
		"tags":{
			"amenity":"theatre",
			"name":"La Cour"
		}
	},
	"2":{
		"id":"2683655977",
		"latitude":"45.4324",
		"longitude":"4.39396",
		"distance":"65.83922717990471",
		"tags":{
			"amenity":"arts_centre",
			"shop":"art",
			"name":"Le Local"
		}
	},
	etc...
*/

$json = json_decode($_GET["json"]);	//Recupere le json passe en parametre GET
$distance = $json->{"distance"};
$latitude = $json->{"latitude"};
$longitude = $json->{"longitude"};
$params = $json->{"params"};

$query = "SELECT *, get_distance_metres(".$latitude.", ".$longitude.", i.latitude, i.longitude) AS dist FROM information i, tag t, cle c WHERE i.id = t.id_info AND t.id_cle = c.id_cle AND (";

$query .= "get_distance_metres(".$latitude.", ".$longitude.", i.latitude, i.longitude) < " . $distance . ") AND (";	//Voir plus bas pour l'explication de la fonction get_distance_metres

$i = 0;
foreach($params as $v) {
	if($i != 0)
		$query .= " OR ";
	$query .= "c.libelle = '" . $v->name . "'";
	$i++;
}
$query .= ")";

$db = new PDO('mysql:host=localhost;dbname=application_android_projet;charset=utf8mb4', 'root', '');	//connexion a la bdd

$nodes = array();	//Tableau a envoyer en reponse

$j = 1;
foreach($db->query($query) as $n) {
	$tags = array();
	foreach($db->query("SELECT id_cle, valeur FROM tag WHERE id_info = " . $n["id"]) as $t) {
		foreach($db->query("SELECT libelle FROM cle WHERE id_cle = " . $t["id_cle"]) as $c) {
			$tags[$c["libelle"]] = $t["valeur"];
			break;
		}
	}
	$nodes[$j] = array(
		"id" => $n["id"],
		"latitude" => $n["latitude"],
		"longitude" => $n["longitude"],
		"distance" => $n["dist"],
		"tags" => $tags
	);
	
	$j++;
}
print(json_encode($nodes));







/*
Fonction SQL : 

CREATE FUNCTION get_distance_metres (lat1 DOUBLE, lng1 DOUBLE, lat2 DOUBLE, lng2 DOUBLE) RETURNS DOUBLE
BEGIN
    DECLARE rlo1 DOUBLE;
    DECLARE rla1 DOUBLE;
    DECLARE rlo2 DOUBLE;
    DECLARE rla2 DOUBLE;
    DECLARE dlo DOUBLE;
    DECLARE dla DOUBLE;
    DECLARE a DOUBLE;
    
    SET rlo1 = RADIANS(lng1);
    SET rla1 = RADIANS(lat1);
    SET rlo2 = RADIANS(lng2);
    SET rla2 = RADIANS(lat2);
    SET dlo = (rlo2 - rlo1) / 2;
    SET dla = (rla2 - rla1) / 2;
    SET a = SIN(dla) * SIN(dla) + COS(rla1) * COS(rla2) * SIN(dlo) * SIN(dlo);
    RETURN (6378137 * 2 * ATAN2(SQRT(a), SQRT(1 - a)));
END|

Remplacez le délimiteur par | (en bas du cadre où vous tapez la requête)
*/
?>