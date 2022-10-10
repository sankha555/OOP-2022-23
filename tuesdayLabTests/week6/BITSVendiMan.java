import java.util.*;
import java.io.*;

class Config{
    private ArrayList<Item> items;
    private ArrayList<Money> paymentModes;
    
    Config(){
        setPaymentModes();
        setItems();
    }
    
    private void setPaymentModes(){
        paymentModes = new ArrayList<>();
        paymentModes.add(new Money("Coin", 5));
        paymentModes.add(new Money("Coin", 10));
        paymentModes.add(new Money("Note", 10));
        paymentModes.add(new Money("Note", 20));
    }
    
    private void setItems(){
        items = new ArrayList<>();
        items.add(new Item("Chips", 20));
        items.add(new Item("Chocolate", 25));
        items.add(new Item("Beverage", 40));
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }
    
    public ArrayList<Money> getPaymentModes() {
        return paymentModes;
    }
}

interface VendiManInterface {
    public int selectItemAndGetPrice(Item item);
    public void printStats();
}

class VendiMan implements VendiManInterface {
    private Inventory<Money> paymentInventory = new Inventory<>();
    private Inventory<Item> itemInventory = new Inventory<>();
    private int totalSales;
    private Item currentItem;
    
    public VendiMan(){
        initialize();
    }
    
    private void initialize(){
        Config config = new Config();
        
        // initialize machine with 20 coins/notes of each denomination
        // and 10 units of each Item
        for(Money paymentMode : config.getPaymentModes()){
            paymentInventory.addNew(paymentMode, 20);
        }
        
        for(Item item : config.getItems()){
            itemInventory.addNew(item, 10);
        }
    }
    
    @Override
    public int selectItemAndGetPrice(Item item) {
        if(itemInventory.hasItem(item)){
            currentItem = item;
            int price = currentItem.getPrice();
            totalSales += price;
            itemInventory.deduct(currentItem);
            return price;
        }
        return -1;
    }
    
    @Override
    public void printStats(){
        System.out.println("Total Sales : " + totalSales);
        System.out.println("Item Inventory : " + itemInventory);
    }
}

/**
 * Items or products supported by Vending Machine.
 */
class Item{
    private String name;
    private int price;
    
    Item(String name, int price){
        this.name = name;
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    
    public int getPrice(){
        return price;
    }
    
    @Override
    public String toString(){
        return name + " (@Rs." + price + ")";
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        return (this.getName().equals(((Item) obj).getName())) &&
                (this.getPrice() == ((Item) obj).getPrice());
    }
}

/**
 * Money in the Vending Machine.
 */
class Money {
    private String denomination;
    private int value;
    
    Money(String denomination, int value){
        this.denomination = denomination;
        this.value = value;
    }
    
    public String getDenomination(){
        return denomination;
    }
    
    public int getValue() {
        return value;
    }
    
    @Override
    public String toString(){
        return denomination + " - " + value;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;
        return (this.getDenomination().equals(((Money) obj).getDenomination())) &&
                (this.getValue() == ((Money) obj).getValue());
    }
}

class Inventory<T> {
    private List<CustomPair<T, Integer>> inventory = new ArrayList<>();
    
    public int getIndex(T inventoryItemEntity){
        int index = -1;
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getFirst().equals(inventoryItemEntity)){
                index = i;
                break;
            }
        }
        return index;
    }
    
    public int getQuantity(T inventoryItemEntity){
        int index = getIndex(inventoryItemEntity);
        return index < 0 ? 0 : inventory.get(index).getSecond();
    }
    
    public void put(T inventoryItemEntity, int quantity) {
        int index = getIndex(inventoryItemEntity);
        T entity = inventory.get(index).getFirst();
        CustomPair<T, Integer> newItem = new CustomPair<T, Integer>(entity, quantity);
        inventory.set(index, newItem);
    }
    
    public void addNew(T inventoryItemEntity, int quantity){
        if (hasItem(inventoryItemEntity)){
            Integer currQuantity = getQuantity(inventoryItemEntity);
            put(inventoryItemEntity, currQuantity + quantity);
        }
        else{
            CustomPair<T, Integer> inventoryItem = new CustomPair<>(inventoryItemEntity, quantity);
            inventory.add(inventoryItem);
        }
    }
    
    public void deduct(T inventoryItemEntity) {
        if (hasItem(inventoryItemEntity)) {
            Integer quantity = getQuantity(inventoryItemEntity);
            put(inventoryItemEntity, quantity - 1);
        }
    }
    
    public boolean hasItem(T inventoryItemEntity){
        return getQuantity(inventoryItemEntity) > 0;
    }
    
    @Override
    public String toString(){
        String inventoryStats = "";
        for(CustomPair<T, Integer> pair : inventory){
            inventoryStats += "\n" + pair.getFirst() + ": " + pair.getSecond();
        }
        return inventoryStats;
    }
}

class CustomPair<T, U> {
    private T first;
    private U second;
    
    public CustomPair(T first, U second){
        this.first = first;
        this.second = second;
    }
    
    public T getFirst(){
        return first;
    }
    
    public U getSecond(){
        return second;
    }
}

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        VendiMan user = new VendiMan();
        
        while(t-- > 0) {
            String name = sc.nextLine();
            int price = Integer.parseInt(sc.nextLine());
            Item item = new Item(name, price);
            user.selectItemAndGetPrice(item);
            user.printStats();
        }
    }
}
