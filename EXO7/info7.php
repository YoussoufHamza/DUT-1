<?php
    $nom = $_POST["nom"];
    $prenom = $_POST["prenom"];
    $email = $_POST["email"];
    $sexe= $_POST["sexe"];
    $pays = $_POST["pays"];
    $langages = $_POST["langages"];
    $pref1 = $_POST["pref1"];

    if((isset($nom)) && (isset($prenom)) && (isset($email)) && (isset($sexe)) && (isset($pays)) && (isset($langages)) && (isset($pref1))){
        echo"Prenom : $prenom <br> Nom : $nom <br> Sexe : $sexe <br> Email : $email <br> Pays : $pays <br> Preference :  $pref1 <br>";
        
        echo"Langages :  <br>";
        foreach($langages as $lang){
            echo" - $lang <br>";
        }
    }else{
        echo("<script>alert('Tout les chanps sont requis');</script>");
        header("location:index.php");
    }

?>