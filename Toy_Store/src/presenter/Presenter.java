package presenter;

import model.Service;
import model.toy.Toy;
import view.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addToyToTheStore(String name, Integer quantity, Integer weight){
        service.addToy(name, quantity, weight);
    }

    public String play(){
       return service.play();
    }

    public void getToyFromQueue(String filePath){
        service.getToyFromQueue(filePath);
    }

    public void showToyStore(){
        view.printText(service.showToyStore());
    }

    public void saveToyStore(String filePath){
        service.saveToyStore(filePath);
    }

    public String loadToyStore(String filePath){
        return service.loadToyStore(filePath);
    }

    public void changeToyName(int id, String toyName){
        service.changeName(id, toyName);
    }

    public void changeToyWeight(int id, Integer weightValue){
        service.changeWeight(id, weightValue);
    }

    public void changeToyQuantity(int id, Integer toyQuantity){
        service.changeQuantity(id, toyQuantity);
    }

    public void clearToyStore(){
        service.clearToyStore();
    }
}
