package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FxFXMLController
{
	@FXML
	// The reference of inputText will be injected by the FXML loader
	private TextField inputText;

	// The reference of outputText will be injected by the FXML loader
	@FXML
	private TextArea outputText;

	// The reference of outputText will be injected by the FXML loader
	@FXML
	public Button okBtn;

	
	// location and resources will be automatically injected by the FXML loader
	@FXML
	private URL location;

	@FXML
	private ResourceBundle resources;

	// Add a public no-args constructor
	public FxFXMLController()
	{
	}
	
	@FXML
	private void initialize()
	{
		
		okBtn.addActionListener(new ActionListener(){
			@Override
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    			printOutput();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}	
	    });
	}

	@FXML
	private void printOutput()
	{
		
		outputText.setText(inputText.getText());
	}
}
