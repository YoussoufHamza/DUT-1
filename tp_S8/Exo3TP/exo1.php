<?php
    function CreerTableau(){
        $notes =array();
        for ($i=0; $i < 60; $i++) { 
            $notes[$i] = (rand(0,66)*0.3);
            
        }
        return $notes;
    }

    function Afficher($Notes){
        echo"</br>Le contenu du tableau est : </br>";
        echo"<table border='1'><tr>";
        foreach($Notes as $elt){
            echo"<td>$elt</td>";
        }
        echo"</tr></table>";
    }

    function Moyenne($Notes){
        $moy=0.0;
        foreach($Notes as $elt){
            $moy+=$elt; 
        }
        $moy = ($moy)/60.0;
        return $moy;
    }

    function Nb_Sup_Mpyenne($Notes){
        $moy=Moyenne($Notes);
        $nbr=0;
        foreach($Notes as $elt){
            if($elt >= $moy) $nbr++; 
        }
        return $nbr;
    }

    function Meilleure($Notes){
        $k=0;
        $ind = array();
        $meil = $Notes[0];
        foreach($Notes as $elt){
            if($elt >= $meil){
                $meil = $elt;
            } 
        }
        for ($i=0; $i < 60; $i++){
            if($Notes[$i] == $meil){
                $ind[$k] = $i;
                $k++;
            } 
        }
        echo"</br>La meilleure note est : $meil ";
        if($k >=2 ){
            echo" et apparait à l'indice ";
            foreach($ind as $i){
                echo"$i, ";
            }
        }   
        echo"</br>";
    }

    $Notes = CreerTableau();

    Afficher($Notes);
    
    $moy = Moyenne($Notes);
    echo"</br>La moyenne de la classe est : $moy</br>";

    $nb = Nb_Sup_Mpyenne($Notes);
    echo"</br>Le nombre de notes >= à la moyenne de la classe est : $nb</br>";
    
    Meilleure($Notes);
?>