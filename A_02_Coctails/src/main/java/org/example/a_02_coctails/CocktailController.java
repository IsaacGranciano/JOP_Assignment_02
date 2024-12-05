package org.example.a_02_coctails;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CocktailController {

    @FXML
    private TextField cocktailNameField;
    @FXML
    private ImageView cocktailImageView;
    @FXML
    private Label cocktailInstructionsLabel;

    private CocktailApiClient apiClient = new CocktailApiClient();

    @FXML
    private void searchCocktail() {
        String cocktailName = cocktailNameField.getText();
        try {
            Cocktail cocktail = apiClient.getCocktail(cocktailName);
            if (cocktail != null) {
                cocktailImageView.setImage(new Image(cocktail.getImage()));
                cocktailInstructionsLabel.setText(cocktail.getInstructions());
            } else {
                cocktailInstructionsLabel.setText("Cocktail not found.");
            }
        } catch (Exception e) {
            cocktailInstructionsLabel.setText("Error fetching cocktail: " + e.getMessage());

            e.printStackTrace();
        }
    }
}