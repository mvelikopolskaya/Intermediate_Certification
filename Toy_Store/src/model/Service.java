package model;

import model.toy.Toy;
import model.toystore.ToyStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Service {
    private ToyStore toyStore;
    private ToyStore prizeToysQueue;
    private int id = 1;

    public Service() {
        toyStore = new ToyStore();
        prizeToysQueue = new ToyStore();
    }

    public void addToy(String name, Integer quantity, Integer weight) {
        Toy toy = new Toy(id++, name, quantity, weight);
        toyStore.addToy(toy);
    }

    public void addPrizeToy(Toy toy) {
        prizeToysQueue.addToy(toy);
    }

    public Toy findByID(Integer requiredID){
        Toy result = null;
        for (Toy toy: toyStore) {
            if(toy.getId().equals(requiredID)){
                result = toy;
            }
        }
        return result;
    }

    public Integer totalWeightsSum(){
        Integer sum = 0;
        for (Toy toy: toyStore) {
            sum+= toy.getWeight() * toy.getQuantity();
        }
        return sum;
    }

    public int choseRandomToyID(){
        Random random = new Random();
        int randomInt = random.nextInt(totalWeightsSum() + 1);
        for (Toy toy: toyStore) {
            Integer frequency = toy.getQuantity() * toy.getWeight();
            if(randomInt - frequency < 0){
                return toy.getId();
            } else {
                randomInt-= frequency;
            }
        }
        return 0;
    }

    public void changeName(int id, String newName){
        Toy toy = findByID(id);
        toy.setName(newName);
    }

    public void changeQuantity(int id, Integer toyQuantity){
        Toy toy = findByID(id);
        toy.setQuantity(toy.getQuantity() + toyQuantity);
    }

    public void changeWeight(int id, Integer weightValue){
        Toy toy = findByID(id);
        toy.setWeight(weightValue);
    }

    public void saveToy(Toy toy, String filePath){
        try(FileWriter writer = new FileWriter(filePath, true)){
            writer.append(toy.getName());
            writer.write("\n");
            writer.flush();
        }catch (IOException e) {
        }
    }

    public void saveToyStore(String filePath){
        try(FileWriter writer = new FileWriter(filePath, true)){
            for (Toy toy: toyStore) {
                writer.append(toy.getToyInfo());
                writer.write("\n");
                writer.flush();
            }
        }catch (IOException e) {
        }
    }

    public String loadToyStore(String filePath) {
        File file = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file);) {
            while (scanner.hasNext()){
                toyFromFile(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
        }
        return stringBuilder.toString();
    }

    public void toyFromFile(String textToy){
        String[] toyData = textToy.split(",");
        try {
            if(toyData.length == 4){
            addToy(toyData[1],
                    Integer.parseInt(toyData[2]),
                    Integer.parseInt(toyData[3]));
            }
        } catch (NumberFormatException e) {
        }
    }

    public void getToyFromQueue(String filePath){
        try {
            Toy prizeToy = prizeToysQueue.getToy(0);
            saveToy(prizeToy, filePath);
            prizeToysQueue.removeToy(0);
        } catch (NullPointerException | IndexOutOfBoundsException e){
        }

    }

    public String play(){
        Integer randomToyID = choseRandomToyID();
        Toy prizeToy = findByID(randomToyID);
        if(prizeToy != null){
            changeQuantity(prizeToy.getId(), -1);
            addPrizeToy(prizeToy);
        }
        return prizeToy.getName();
    }

    public void clearToyStore(){
        toyStore.clearToyStore();
    }

    public String showToyStore(){
        StringBuilder stringBuilder = new StringBuilder();
        try{
            stringBuilder.append("Список игрушек");
            stringBuilder.append("\n");
            for (Toy toy : toyStore) {
                stringBuilder.append(toy);
                stringBuilder.append("\n");
            }
        }catch(NullPointerException e){
        }
        return stringBuilder.toString();
    }
}
