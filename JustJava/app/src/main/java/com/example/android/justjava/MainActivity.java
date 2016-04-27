package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int numberOfCoffees = 2;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the + button is clicked.
     */

    public void increment(View view) {
        if (numberOfCoffees < 100) {
            numberOfCoffees = numberOfCoffees + 1;
            display(numberOfCoffees);
        } else {
            Toast.makeText(getApplicationContext(), "You cannot have more than 100 coffee", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * This method is called when the - button is clicked.
     */

    public void decrement(View view) {
        if (numberOfCoffees > 1) {
            numberOfCoffees = numberOfCoffees - 1;
            display(numberOfCoffees);
        } else {
            Toast.makeText(getApplicationContext(), "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean haswhippedCream = whippedCreamCheckbox.isChecked();
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean haschocolate = chocolate.isChecked();
        EditText cname = (EditText) findViewById(R.id.name_view);
        name = cname.getText().toString();
        int price = calculatePrice(haswhippedCream, haschocolate);

        displayMessage(createOrderSummary(price, haswhippedCream, haschocolate));
    }

    /**
     * @param addwhippedCream is to check whether the user wants whipped cream
     * @param addchocolate    is to check whether the user wants chocolate
     * @return the total price after adding price of whipped cream/ chocolate/ both.
     */
    public int calculatePrice(boolean addwhippedCream, boolean addchocolate) {
        int totalprice = 5;
        if (addwhippedCream)
            totalprice += 1;
        if (addchocolate)
            totalprice += 2;
        totalprice *= numberOfCoffees;
        return totalprice;
    }

    /**
     * Create summary of the order
     *
     * @param price           is the total bill amount
     * @param addchocolate    is whether or not the user wants chocolate
     * @param addwhippedCream is whether or not the user wants whipped cream
     * @return returns the total price
     */
    public String createOrderSummary(int price, boolean addwhippedCream, boolean addchocolate) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd Whipped Cream? " + addwhippedCream;
        priceMessage += "\nAdd Chocolate? " + addchocolate;
        priceMessage += "\nQuantity: " + numberOfCoffees;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";

        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);

    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
