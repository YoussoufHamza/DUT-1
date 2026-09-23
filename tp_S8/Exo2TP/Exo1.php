<?php
    $input = $_POST["IPadr"];
    $adr = explode(".", $input);

    if(isset($input)){
        if((count($adr) != 4)){
            echo"<script>alert('$input est une adresse invalide');</script>";
        }else{
            $valide = 1;
            $valide2 = 1;
            if(($adr[0]<1) || ($adr[0]>255)){
                $valide2 = 0;
            }
            for ($i=1; $i < count($adr); $i++) { 
                if(($adr[$i]<0) || ($adr[$i]>255)){
                    $valide = 0;
                    break;
                }
            }
            if(($valide == 0) || ($valide2 == 0)){
                echo"<script>alert('$input est une adresse invalide');</script>";
            }else if(($valide == 1) && ($valide2 == 1)){
                if(($adr[0]>=1) && ($adr[0]<=126) && ($adr[0] != 127)){
                    echo"<script>alert('$input est une adresse valide classe A');</script>";
                }else if(($adr[0]<=191) && ($adr[0]>=128) && ($adr[0] != 127)){
                    echo"<script>alert('$input est une adresse valide classe B');</script>";
                }else if(($adr[0]<=223) && ($adr[0]>=192) && ($adr[0] != 127)){
                    echo"<script>alert('$input est une adresse valide classe C');</script>";
                }else if(($adr[0]<=239) && ($adr[0]>=224) && ($adr[0] != 127)){
                    echo"<script>alert('$input est une adresse valide classe D');</script>";
                }else if(($adr[0]<=255) && ($adr[0]>=240) && ($adr[0] != 127)){
                    echo"<script>alert('$input est une adresse valide classe E');</script>";
                }else{
                    echo"<script>alert('$input est une adresse valide mais elle est réservée au communications en boucle locale');</script>";
                }
            }else{
                echo"<script>alert('$input est une adresse invalide');</script>";
            }
        }
    }else{
        echo"Veillez entrer une adresse svp !";
    }
    
    

?>