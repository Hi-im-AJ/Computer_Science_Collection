package main.mvvm.viewModel;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Observable;

import main.mvvm.model.MainModel;
import main.mvvm.persistance.DatabaseHandler;

public class MainViewModel extends Observable {
    private final MainModel mainModel = new MainModel();
    private final DatabaseHandler databaseHandler;

    private String header = this.mainModel.getHeader();

    public MainViewModel(Context context) {
        observeModel(mainModel);
        this.databaseHandler = new DatabaseHandler(context);
    }

    private void observeModel(MainModel model) {
        model.addObserver((o, arg) -> {
            String header = ((MainModel) o).getHeader();
            this.header = capitalizeFirstLetter(header);

            MainViewModel.super.setChanged();
            MainViewModel.super.notifyObservers();
        });
    }

    private String capitalizeFirstLetter(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public String getHeader() {
        Cursor cursor = this.databaseHandler.getHeaders();
        if(cursor.getCount() == 0) return capitalizeFirstLetter(this.header);
        ArrayList<String> headers = new ArrayList<>();
        while(cursor.moveToNext()) {
            headers.add(cursor.getString(1));
        }
        return capitalizeFirstLetter(headers.get(headers.size()-1));
    }

    public void setHeader(String str) {
        this.databaseHandler.insertHeader(str);
        this.mainModel.setHeader(str);
    }
}
