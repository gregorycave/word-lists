package word_list;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Word_List implements ActionListener {

    // Class declaration for Exercise 2.
    private LinkedList<String> wordList = new LinkedList<>();
    private JTextField userInput;
    private JButton addBtn, wordDisplayBtn, listSearchBtn, rmvLastBtn, rmvAllBtn, clrTextBtn;
    private JLabel wordsDisplay, regNumber;
    private JPanel topPnl, btmPnl;



    private void initUi(){

        // Method to create and position GUI elements
        JFrame container = new JFrame();
        container.setMinimumSize(new Dimension(900,150));
        container.setTitle("Word Lists");
        container.setLayout(new BoxLayout(container.getContentPane(), BoxLayout.Y_AXIS));
        topPnl = new JPanel();
        btmPnl = new JPanel();
        topPnl.setLayout(new GridLayout(1,6));
        btmPnl.setLayout(new GridLayout(3, 1));
        container.add(topPnl);
        container.add(btmPnl);

        topPnl.setMaximumSize(new Dimension(900, 100));
        btmPnl.setMinimumSize(new Dimension(700, 200));
        btmPnl.setMaximumSize(new Dimension(700, 200));

        userInput = new JTextField();
        userInput.setMaximumSize(new Dimension(200, 50));
        addBtn = new JButton("Add Word");
        wordDisplayBtn = new JButton("Display Words");
        listSearchBtn = new JButton("Search");
        rmvLastBtn = new JButton("Remove Last Word");
        rmvAllBtn = new JButton("Remove Words");
        clrTextBtn = new JButton("Clear List");
        wordsDisplay = new JLabel();
        wordsDisplay.setMinimumSize(new Dimension(100,100));
        topPnl.add(addBtn);
        topPnl.add(wordDisplayBtn);
        topPnl.add(listSearchBtn);
        topPnl.add(rmvLastBtn);
        topPnl.add(rmvAllBtn);
        topPnl.add(clrTextBtn);
        btmPnl.add(wordsDisplay);
        btmPnl.add(userInput);
        container.setVisible(true);
    }



    public Word_List(){
        // Constructor for the GUI.

        initUi();
        addBtn.setActionCommand("addBt");
        addBtn.addActionListener(this);
        wordDisplayBtn.setActionCommand("displayBt");
        wordDisplayBtn.addActionListener(this);
        listSearchBtn.setActionCommand("searchBt");
        listSearchBtn.addActionListener(this);
        rmvLastBtn.setActionCommand("removeLastBt");
        rmvLastBtn.addActionListener(this);
        rmvAllBtn.setActionCommand("removeAllBt");
        rmvAllBtn.addActionListener(this);
        clrTextBtn.setActionCommand("clearBt");
        clrTextBtn.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // Button Handler.

        String action = e.getActionCommand();

        if (action.equals("addBt")){
            String input = userInput.getText();
            String pattern = "[a-zA-Z][a-zA-Z-0-9]*";
            if (input.matches(pattern)){
                wordList.add(input);
                wordsDisplay.setText("Word '" + input + "' has been added to the list.");
            }
            else {
                wordsDisplay.setText("The string '"+ input + "' was not added to the list as it is not a valid word.");
            }
        }


        else if (action.equals("displayBt")){
            String displayString = "";
            String input = userInput.getText();
            String pattern = "(.)*(\\w)*([d" + input + "])";
            for (int i = 0; i < wordList.size(); i++) {
                if (wordList.get(i).matches(pattern)) {
                    displayString += wordList.get(i) + " ";
                }
            }
            wordsDisplay.setText("The current words in the list are - " + displayString);
        }


        else if (action.equals("searchBt")) {
            int occurrenceCount = 0;
            String outputString = "";
            ArrayList<Integer> positions = new ArrayList<>();
            String input = userInput.getText().toLowerCase();

            if (input == null || input.equals("")){
                outputString = "There are " + wordList.size() + " words in the list.";
            }
            else {
                for (int i = 0; i < wordList.size(); i++) {
                    if (input.equals(wordList.get(i).toLowerCase())) {
                        occurrenceCount++;
                        positions.add(i);
                    }
                }

                if (occurrenceCount == 0) {
                    outputString = "Word '"+ input + "' not found in the list.";
                }

                else {
                    outputString = "Word '"+ input + "' found in the list " + occurrenceCount + " times at position(s): ";
                    for (int i = 0; i < positions.size(); i++){
                        outputString += positions.get(i) + " ";
                    }
                }
            }
            wordsDisplay.setText(outputString);
        }


        else if(action.equals("removeLastBt")){
            String input = userInput.getText().toLowerCase();
            int removalCount = 0;

            for (int i = wordList.size()-1; i>=0; i--){
                if(wordList.get(i).toLowerCase().equals(input)){
                    wordList.remove(i);
                    removalCount++;
                    break;
                }
            }

            if (removalCount==1) {
                wordsDisplay.setText("Last occurence of: " + input + " had been removed.");
            }
            else {
                wordsDisplay.setText("Word '"+ input + "' not found in the list.");
            }
        }


        else if(action.equals("removeAllBt")){
            String input = userInput.getText();
            int removalCount = 0;

            for (int i = wordList.size()-1; i>=0; i--){
                if(wordList.get(i).equals(input)){
                    wordList.remove(i);
                    removalCount++;
                }
            }

            if (removalCount>0){
                wordsDisplay.setText("All words have been successfully removed.");
            }
            else {
                wordsDisplay.setText("Word '"+ input + "' not found in the list.");
            }
        }


        else if(action.equals("clearBt")){
            wordList.removeAll(wordList);
            wordsDisplay.setText("The contents of the list has been cleared.");
        }
    }
}
