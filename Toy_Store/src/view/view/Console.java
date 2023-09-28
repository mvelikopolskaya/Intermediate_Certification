package view.view;

import presenter.Presenter;
import view.commands.MainMenu;
import view.commands.Menu;
import view.commands.PlayerMenu;
import view.commands.StoreMenu;
import java.util.Scanner;

public class Console implements View{
    private Presenter presenter;
    private Scanner scanner;
    private  boolean flag;
    private Menu menu;

    public Console() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        menu = new MainMenu(this);
        flag = true;
    }
    @Override
    public void start() {
        while (flag) {
            System.out.println("Выберите действие");
            System.out.println(menu.menu());
            System.out.print(">");
            String act = scanner.nextLine();
            int actInt = Integer.parseInt(act);
            if (actInt >= 0) {
                menu.execute(actInt);
            }
        }
    }

    public void addToyToTheStore(){
        System.out.println("Введите название игрушки");
        System.out.print(">");
        String name = scanner.nextLine();
        System.out.println("Введите количество игрушек");
        System.out.print(">");
        Integer quantity = scanner.nextInt();
        System.out.println("Введите вес игрушки");
        System.out.print(">");
        Integer weight = scanner.nextInt();
        scanner.nextLine();
        presenter.addToyToTheStore(name, quantity, weight);
    }

    public void changeToyName(){
        System.out.println("Введите ID нужной игрушки");
        try{
            String id = scanner.nextLine();
            int idInt = Integer.parseInt(id);
            System.out.println("Введите новое название");
            System.out.print(">");
            String newName = scanner.nextLine();
            presenter.changeToyName(idInt, newName);
        } catch (Exception e) {
        }
    }

    public void changeToyQuantity(){
        System.out.println("Введите ID нужной игрушки");
        try{
            String id = scanner.nextLine();
            int idInt = Integer.parseInt(id);
            System.out.println("Сколько игрушек добавить?");
            System.out.println("(для изъятия игрушек введите отрицательное число)");
            System.out.print(">");
            String newQuantity = scanner.nextLine();
            Integer newQuantituInt = Integer.parseInt(newQuantity);
            presenter.changeToyQuantity(idInt, newQuantituInt);
        } catch (Exception e) {
        }
    }

    public void changeToyWeight(){
        System.out.println("Введите ID нужной игрушки");
        try{
            String id = scanner.nextLine();
            int idInt = Integer.parseInt(id);
            System.out.println("Введите новый вес");
            System.out.print(">");
            String newWeight = scanner.nextLine();
            Integer newWeightInt = Integer.parseInt(newWeight);
            presenter.changeToyWeight(idInt, newWeightInt);
        } catch (Exception e) {
        }
    }

    public void clearToyStore(){
        presenter.clearToyStore();
    }

    public void play(){
        System.out.println("Вы выиграли: " + presenter.play());
    }

    public void getToyFromQueue(){
        System.out.println("Введите путь сохранения и имя файла");
        String filepath = "src/test.txt";
        presenter.getToyFromQueue(filepath);
    }

    public void showToyStore(){
        presenter.showToyStore();
    }

    public void saveToyStore(){
        System.out.println("Введите путь сохранения и имя файла");
        String filepath = scanner.nextLine();
        presenter.saveToyStore(filepath);
    }

    public void loadToyStore(){
        System.out.println("Введите путь сохранения и имя файла");
        String filepath = scanner.nextLine();
        presenter.loadToyStore(filepath);
        showToyStore();
    }

    public void choseAdmin(){
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        if(password.equals("123")){
            menu = new StoreMenu(this);
            start();
        } else{
            System.out.println("Неверный пароль");
        }
    }

    public void chosePlayer(){
        menu = new PlayerMenu(this);
        start();
    }

    public void returnToMainMenu(){
        menu = new MainMenu(this);
        start();
    }
    public void finish() {
        flag = false;
    }

    @Override
    public void printText(String text) {
        System.out.println(text);
    }
}
