public class TestPizza{
    public void main(String[] args){
       Client client, client1;
       client = new Client("Brondon", "Maroc, salé, Rue 4, appt 3");
       client1 = new Client("Floriant", "Cameroun, yaounde, Rue 4, appt 3");
       

       Livreur livreur;
       livreur =  new Livreur("Donatien", "+212 0635264352");

       Pizza pizza, pizza1;

       pizza = new Pizza("Hawaienne", "Fromage, Tomate, Oignons", "Moyenne");
       pizza1 = new Pizza("Italienne", "Fromage, Tomate, Oignons", "Moyenne");

       livreur.livrerPizza(pizza, client.commanderPizza(pizza), client);
       livreur.livrerPizza(pizza1, client1.commanderPizza(pizza1), client1);

       livreur.livrerPizza(pizza1, client.commanderPizza(pizza), client);
       livreur.livrerPizza(pizza, client1.commanderPizza(pizza1), client1);

       System.out.println("\n\n");

    }    
}