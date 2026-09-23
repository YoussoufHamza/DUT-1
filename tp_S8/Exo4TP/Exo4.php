<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Les nombres premiers</title>

</head>
<body>

        <!-- Formulaire -->
        
        <form action="Exo4.php" method="post">
                <h1>Les nombres premiers</h1>
                <input type="number" placeholder="Saisir un nombre" name="nombre" required> <br>

                <button type="submit">Afficher Tous Les Nombres Premiers</button>
        </form>
</body>
</html>

<script type="javascript"></script>

<style>
    *{
    box-sizing: border-box;
    overflow-x: hidden;
    font-family: 'Times New Roman', Times, serif;
    font-size: 25px;
}

h1{
    text-align: center;
    font-weight: bolder;
    font-size: 40px;
}

form{
    margin-top: 10%;
    padding: 3% 25% 0% 25%;
    width: 100%;
    justify-content: center;
}

input[type="number"]{
    border: .2px solid gray;
    width: 100%;
    margin: 1%;
    padding: 1%;
}


button{
    margin: 2%;
    padding: 1%;
    width: 100%;
    border-radius: .2rem;
    border: none;
    color: #fff;
    cursor: pointer;
}

button[type="submit"]{
    background-color: blue;
}



</style>



<?php
    
    if(isset($_POST["nombre"])){ 
        $nbre = $_POST["nombre"];
        echo"</br><h4><b> Les nombres premiers inférieurs à $nbre sont : </b></br>";
        
        for ($i=2; $i < $nbre ; $i++){
            $div = 0;
            for ($j=1; $j <= $i ; $j++){
                if($i%$j == 0){
                    $div++;
                }
            }    
            if($div == 2){
                echo"\t\t\t\t  $i ";
            }
        } 
        
    }
    

?>