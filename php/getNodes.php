<?php

$json = json_decode($_GET["json"]);	//Recupere le json passe en parametre GET
$query = "SELECT * FROM information i, tag t, cle c WHERE i.id = t.id_info AND t.id_cle = c.id_cle AND (";

$distance = $json->{"distance"};
$latitude = $json->{"latitude"};
$longitude = $json->{"longitude"};
//$query .= $distance . ") AND (";

$params = $json->{"params"};
$i = 0;
foreach($params as $v) {
	if($i != 0)
		$query .= " OR ";
	$query .= "c.libelle = '" . $v->name . "'";
	//echo $v->name." $i<br/>";
	$i++;
}
$query .= ")";
$db = new PDO('mysql:host=localhost;dbname=application_android_projet;charset=utf8mb4', 'root', '');
$nodes = array();
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
		"tags" => $tags
	);
	//print(json_encode($nodes[$j]));
	$j++;
}
print(json_encode($nodes));









/*
------------Requete-----------

 [0] => Array ( 
	[id] => 2683655977 
	[0] => 2683655977 $
	[latitude] => 45.4324 
	[1] => 45.4324 
	[longitude] => 4.39396 
	[2] => 4.39396 
	[valeur] => art 
	[3] => art 
	[libelle] => shop 
	[4] => shop 
) 



Execmple de requete SQL : 
SELECT * FROM information i, tag t, cle c 
WHERE i.id = t.id_info AND 
	c.id_cle = t.id_cle AND 
	(c.libelle = 'amenity' OR c.libelle = 'shop')

Exemple de retour : 
id, latitude, longitude, id_info, id_cle, valeur, id_cle, libelle
26316541651, 45.431231, 4.39123123, 26316541651, 6, art, 6, shop
	
	
$query =mysql_query("SELECT * FROM information");
while ($row=mysql_fetch_array($query)) {    
    $output[]=$row;    
} 
/*
------------Encodage JSON et envoi-----------

print(json_encode($output));
mysql_free_result ($query);  
*/
?>