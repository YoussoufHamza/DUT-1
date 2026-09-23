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
        
        <form action="info7.php" method="post">
            
                <fieldset>
                    <legend>Formulaire d'inscription</legend>
                    <input type="text" placeholder="Saisir votre nom" name="nom"> <br>
                    <input type="text" placeholder="Saisir votre prenom" name="prenom"> <br>
                    <input type="email" placeholder="Saisir votre Email" name="email"> <br>

                    <label for="Sexe">Sexe Masculin <input type="radio" name="sexe" id="sexe" value="Masculin" checked> Féminin <input type="radio" name="sexe" id="sexe" value="Féminin"></label> <br>

                    <select name="pays" id="pays" placeholder="Choisissez un pays">
                        <option value="">Choisissez un pays</option>
                        <option value="Cameroun"> Cameroun</option>
                        <option value="Niger"> Niger</option>
                        <option value="Maroc"> Maroc</option>
                        <option value="Tchad"> Tchad</option>
                        <option value="Egypte"> Egypte</option>
                        <option value="Mali"> Mali</option>
                        <option value="USA"> USA</option>
                        <option value="France"> France</option>
                    </select> <br><br>
                    <label for="Langues"> Les langages préférés </label> <br>

                    <select name="langages[]" id="langages" aria-placeholder="Choisissez un pays" class="selc2" multiple>
                        <option value="Java"> Java</option>
                        <option value="C"> C</option>
                        <option value="C++"> C++</option>
                        <option value="PHP"> PHP</option>
                        <option value="HTML"> HTML</option>
                        <option value="Python"> Python</option>
                    </select>

                    <br>
                    <br>
                    <label>(Pour faire plusieurs choix maintenez la touche <b>CTRL</b> enfoncée)</label>
                    <input type="checkbox" name="pref1" id="pref" value="Informatique"> Informatique

                    <input type="checkbox" name="pref1" id="pref" value="Gestion"> Gestion

                    <input type="checkbox" name="pref1" id="pref" value="Pédagogie"> Pédagogie <br>

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


input[type="text"],
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
    padding: 2%;
    width: 150px;
    border-radius: .2rem;
    border: none;
    color: #fff;
    cursor: pointer;
}

button[type="submit"]{
    background-color: green;
}

button[type="reset"]{
    background-color: red;
}

</style>

