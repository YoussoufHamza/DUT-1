<?php
    
    $nbr = random_int(100, 100000);
    $chaine = $nbr."";
    $chainer = strrev($chaine);
    
    echo" <p><br>Le nombre choisi est $nbr </p>";
    echo" <p><br>Le nombre en sens inverse est $chainer</p>";

?>