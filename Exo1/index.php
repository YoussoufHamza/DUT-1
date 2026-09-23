<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire d'inscription</title>
    <!-- <link rel="stylesheet" href="./css/style.css">
     
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'> -->
</head>
<body>

        <!-- Formulaire -->
        
        <form action="exo1.php" method="post">
            
                <fieldset>
                    <legend>Exercice 1 TP</legend>
                    <input type="number" placeholder="Saisir un nombre" name="nombre" required> <br>

                    <button type="submit">Envoyer</button> <button type="reset">Annuler</button>

                </fieldset>
           
            
        </form>
</body>
</html>

<script type="javascript"></script>

<style>
    *{
    box-sizing: border-box;
    font-family: 'Times New Roman', Times, serif;
    font-size: 25px;
}

form{
    margin-top: 10%;
    padding: 3% 25% 0% 25%;
    width: 100%;
    justify-content: center;
}


table{
    width: 100%;
    padding: 0 8%;
    background-color: #fbf7f7;
}


legend{
    text-align: left;
    font-weight: bolder;
    font-size: larger;
}


input[type="number"],
input[type="email"]{
    border: .2px solid gray;
    width: 100%;
    margin: 1%;
    padding: 1%;
}

select{
    width: 100%; 
    padding: 1%;
}

.selc2{
    height: 200px;
}

input[type="radio"],
input[type="checkbox"]{
    
}

button{
    margin: 2%;
    padding: 1%;
    width: 150px;
    border-radius: .2rem;
    border: none;
    color: #fff;
    cursor: pointer;
}

button[type="submit"]{
    background-color: blue;
    margin-left: 29%;
}

button[type="reset"]{
    background-color: red;
}

</style>

