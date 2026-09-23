<?php
    $nbre = $_POST["nombre"];
    $som = 0;
    for ($i=1; $i <= $nbre/2 ; $i++)  
        if($nbre%$i == 0) $som +=$i;
    
    if($nbre == $som) echo" <p><br>$nbre est un nomre parfait </p>";
    else echo" <p><br>$nbre n'est pas un nombre parfait </p>";

?>