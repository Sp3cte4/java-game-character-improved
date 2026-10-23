
package gamecharacter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameGUI extends JFrame {

    private final CharacterManager manager = new CharacterManager();

    private final DefaultListModel<Game_Character> listModel =
            new DefaultListModel<>();

    private final JList<Game_Character> characterList =
            new JList<>(listModel);

    private final JTextField nameField = new JTextField(14);

    private final JComboBox<String> typeBox =
            new JComboBox<>(new String[]{"Warrior", "Mage","Paladin", "Assassin", "Archer"});

    private final JTextArea battleLog = new JTextArea();

    private final JLabel characterTitle = new JLabel("Select a character");
    private final JLabel healthLabel = new JLabel("Health: -");

    private final JProgressBar healthBar = new JProgressBar(0, 100);

    private final Color background = new Color(20, 24, 38);
    private final Color panelColor = new Color(37, 44, 62);
    private final Color gold = new Color(255, 205, 100);
    private final Color white = new Color(245, 247, 255);

    private JButton attackButton;
    private JButton passiveButton;
    private JButton ultimateButton;

    public GameGUI() {
        setTitle("Fantasy Arena - Character Creator");
        setSize(1050, 750);
        setMinimumSize(new Dimension(900, 650));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        buildInterface();
        addDefaultCharacters();

        log("Welcome to Fantasy Arena!");
        log("Select a character to use its abilities.");
    }

    private void buildInterface() {

        JPanel root = new JPanel(new BorderLayout(15, 15));
        root.setBackground(background);
        root.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(root);

        // HEADER

        JLabel heading = new JLabel("FANTASY ARENA");
        heading.setFont(new Font("Serif", Font.BOLD, 36));
        heading.setForeground(gold);

        JLabel subtitle = new JLabel(
                "CHARACTER CREATOR  |  BATTLE SIMULATOR");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 15));
        subtitle.setForeground(white);

        JPanel header = new JPanel(new GridLayout(2, 1, 0, 6));
        header.setBackground(background);
        header.add(heading);
        header.add(subtitle);

        root.add(header, BorderLayout.NORTH);

        

        JPanel left = createPanel("CHARACTER ROSTER");
        left.setPreferredSize(new Dimension(310, 500));
        left.setLayout(new BorderLayout(10, 12));

        characterList.setBackground(panelColor);
        characterList.setForeground(white);
        characterList.setSelectionBackground(new Color(91, 70, 140));
        characterList.setSelectionForeground(Color.WHITE);
        characterList.setFont(new Font("SansSerif", Font.PLAIN, 16));
        characterList.setFixedCellHeight(40);

        left.add(new JScrollPane(characterList), BorderLayout.CENTER);

        JPanel creator = new JPanel(new GridBagLayout());
        creator.setBackground(panelColor);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 5, 6, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        JLabel creatorTitle = new JLabel("CREATE YOUR CHARACTER");
        creatorTitle.setForeground(gold);
        creatorTitle.setFont(new Font("SansSerif", Font.BOLD, 14));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        creator.add(creatorTitle, gbc);

        JLabel nameLabel = new JLabel("Character name:");
        nameLabel.setForeground(white);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        creator.add(nameLabel, gbc);

        styleInput(nameField);

        gbc.gridx = 1;
        creator.add(nameField, gbc);

        JLabel typeLabel = new JLabel("Character class:");
        typeLabel.setForeground(white);

        gbc.gridx = 0;
        gbc.gridy = 2;
        creator.add(typeLabel, gbc);

        typeBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        typeBox.setBackground(Color.WHITE);
        typeBox.setForeground(Color.BLACK);

        gbc.gridx = 1;
        creator.add(typeBox, gbc);

        JButton createButton = makeButton(
                "CREATE CHARACTER",
                new Color(190, 145, 45));

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        creator.add(createButton, gbc);

        JButton removeButton = makeButton(
                "REMOVE CHARACTER",
                new Color(175, 55, 65));

        gbc.gridy = 4;
        creator.add(removeButton, gbc);
        
        JButton updateButton = makeButton(
                "UPDATE CHARACTER",
                new Color(45, 115, 180));

        gbc.gridy = 5;
        creator.add(updateButton, gbc);
        
        left.add(creator, BorderLayout.SOUTH);

        

        JPanel right = new JPanel(new BorderLayout(12, 12));
        right.setBackground(background);

       

        JPanel status = createPanel("CHARACTER STATUS");
        status.setLayout(new BoxLayout(status, BoxLayout.Y_AXIS));

        characterTitle.setForeground(gold);
        characterTitle.setFont(new Font("Serif", Font.BOLD, 27));

        healthLabel.setForeground(white);
        healthLabel.setFont(new Font("SansSerif", Font.BOLD, 17));

        healthBar.setStringPainted(true);
        healthBar.setFont(new Font("SansSerif", Font.BOLD, 14));
        healthBar.setForeground(new Color(40, 190, 110));
        healthBar.setBackground(new Color(55, 60, 75));
        healthBar.setPreferredSize(new Dimension(400, 30));
        healthBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        status.add(characterTitle);
        status.add(Box.createVerticalStrut(15));
        status.add(healthLabel);
        status.add(Box.createVerticalStrut(8));
        status.add(healthBar);

        

        JPanel abilities = createPanel("CHARACTER ABILITIES");
        abilities.setLayout(new GridLayout(1, 3, 12, 12));

        attackButton = makeButton(
                "ATTACK",
                new Color(185, 55, 65));

        passiveButton = makeButton(
                "PASSIVE",
                new Color(30, 145, 95));

        ultimateButton = makeButton(
                "ULTIMATE",
                new Color(105, 75, 190));

        abilities.add(attackButton);
        abilities.add(passiveButton);
        abilities.add(ultimateButton);

        

        JPanel logPanel = createPanel("BATTLE LOG");
        logPanel.setLayout(new BorderLayout(8, 8));

        battleLog.setEditable(false);
        battleLog.setLineWrap(true);
        battleLog.setWrapStyleWord(true);
        battleLog.setBackground(new Color(12, 15, 25));
        battleLog.setForeground(new Color(240, 243, 255));
        battleLog.setCaretColor(Color.WHITE);
        battleLog.setFont(new Font("Monospaced", Font.PLAIN, 15));
        battleLog.setMargin(new Insets(12, 12, 12, 12));

        JScrollPane logScroll = new JScrollPane(battleLog);
        logScroll.setPreferredSize(new Dimension(500, 190));
        logPanel.add(logScroll, BorderLayout.CENTER);

        JButton clearButton = makeButton(
                "CLEAR LOG",
                new Color(75, 85, 110));

        clearButton.addActionListener(e -> battleLog.setText(""));

        logPanel.add(clearButton, BorderLayout.SOUTH);

        right.add(status, BorderLayout.NORTH);
        right.add(abilities, BorderLayout.CENTER);
        right.add(logPanel, BorderLayout.SOUTH);

        root.add(left, BorderLayout.WEST);
        root.add(right, BorderLayout.CENTER);

       

        createButton.addActionListener(e -> createCharacter());
        removeButton.addActionListener(e -> removeCharacter());
        updateButton.addActionListener(e -> updateCharacter());

        characterList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                updateStatus();
            }
        });

        attackButton.addActionListener(e -> useAbility("attack"));
        passiveButton.addActionListener(e -> useAbility("passive"));
        ultimateButton.addActionListener(e -> useAbility("ultimate"));

        setAbilityButtonsEnabled(false);
    }

    private JPanel createPanel(String title) {

        JPanel panel = new JPanel();

        panel.setBackground(panelColor);

        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(
                                new Color(85, 95, 120)),
                        title,
                        0,
                        0,
                        new Font("SansSerif", Font.BOLD, 14),
                        gold),
                new EmptyBorder(12, 12, 12, 12)));

        return panel;
    }

    private JButton makeButton(String text, Color color) {

        JButton button = new JButton(text);

        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(color);

        
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
        button.setFocusPainted(false);

        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        color.brighter(), 1),
                new EmptyBorder(12, 8, 12, 8)));

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }

    private void styleInput(JTextField field) {
        field.setFont(new Font("SansSerif", Font.PLAIN, 15));
        field.setForeground(Color.BLACK);
        field.setBackground(Color.WHITE);
        field.setCaretColor(Color.BLACK);
        field.setOpaque(true);
    }

    private void addDefaultCharacters() {

        manager.addCharacter(new Warrior("Arthas"));
        manager.addCharacter(new Mage("Merlin"));

        refreshList();
        characterList.setSelectedIndex(0);
    }

    private void createCharacter() {

        String name = nameField.getText().trim();

        if (name.isEmpty()) {
            showError("Please enter a character name.");
            return;
        }

        if (name.length() > 20) {
            showError("Name must be 20 characters or fewer.");
            return;
        }

        if (!name.matches("[\\p{L}\\p{N} _'-]+")) {
            showError("Use letters, numbers, spaces, or simple punctuation.");
            return;
        }

        if (manager.findCharacter(name) != null) {
            showError("That character name already exists.");
            return;
        }


Game_Character character;

String selectedType = (String) typeBox.getSelectedItem();

switch (selectedType) {
    case "Warrior":
        character = new Warrior(name);
        break;

    case "Mage":
        character = new Mage(name);
        break;

    case "Paladin":
        character = new Paladin(name);
        break;

    case "Assassin":
        character = new Assassin(name);
        break;
    
    case "Archer":
        character = new Archer(name);
        break;

    default:
        showError("Please select a valid character class.");
        return;
}

manager.addCharacter(character);


        refreshList();
        characterList.setSelectedValue(character, true);
        nameField.setText("");

        log("Created " + character.getCharacterType()
                + ": " + character.getName());
    }

    private void removeCharacter() {

        Game_Character selected = characterList.getSelectedValue();

        if (selected == null) {
            showError("Please select a character.");
            return;
        }

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Remove " + selected.getName() + "?",
                "Confirm Removal",
                JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {

            String name = selected.getName();

            manager.removeCharacter(name);

            refreshList();
            clearStatus();

            log("Removed character: " + name);
        }
    }

    private void useAbility(String ability) {

        Game_Character character = characterList.getSelectedValue();

        if (character == null) {
            showError("Please select a character first.");
            return;
        }

        if (!character.isAlive()) {
            showError("This character has been defeated.");
            return;
        }

        String result;

        switch (ability) {
            case "attack":
                result = character.attack();
                break;

            case "passive":
                result = character.passive();
                break;

            case "ultimate":
                result = character.ultimate();
                break;

            default:
                return;
        }

        log("");
        log("Character: " + character.getName());
        log(result);

        updateStatus();
    }

    private void refreshList() {

        listModel.clear();

        for (Game_Character character : manager.getCharacters()) {
            listModel.addElement(character);
        }
    }

    private void updateStatus() {

        Game_Character character = characterList.getSelectedValue();

        if (character == null) {
            clearStatus();
            return;
        }

        characterTitle.setText(
                character.getName() + " - "
                + character.getCharacterType());

        healthLabel.setText(
                "Health: " + character.getHealth()
                + " / " + character.getMaxHealth());

        int percent = (int) (
                100.0 * character.getHealth()
                / character.getMaxHealth());

        healthBar.setValue(percent);
        healthBar.setString(percent + "%");

        setAbilityButtonsEnabled(character.isAlive());
    }

    private void clearStatus() {

        characterTitle.setText("Select a character");
        healthLabel.setText("Health: -");
        healthBar.setValue(0);
        healthBar.setString("");

        setAbilityButtonsEnabled(false);
    }

    private void setAbilityButtonsEnabled(boolean enabled) {

        attackButton.setEnabled(enabled);
        passiveButton.setEnabled(enabled);
        ultimateButton.setEnabled(enabled);
    }

    private void log(String message) {

        battleLog.append(message + "\n");

        battleLog.setCaretPosition(
                battleLog.getDocument().getLength());
    }

    private void showError(String message) {

        JOptionPane.showMessageDialog(
                this,
                message,
                "Fantasy Arena",
                JOptionPane.WARNING_MESSAGE);
    }
 
    private void updateCharacter() {
        Game_Character selected = characterList.getSelectedValue();

        if (selected == null) {
            showError("Please select a character to update.");
            return;
        }

        String newName = JOptionPane.showInputDialog(
                this,
                "Enter the new name for " + selected.getName() + ":",
                selected.getName()
        );

        if (newName == null) {
            return;
        }

        newName = newName.trim();

        if (newName.isEmpty()) {
            showError("Character name cannot be empty.");
            return;
        }

        if (newName.length() > 20) {
            showError("Name must be 20 characters or fewer.");
            return;
        }

        if (!newName.matches("[\\p{L}\\p{N} _'-]+")) {
            showError("Use letters, numbers, spaces, or simple punctuation.");
            return;
        }

        Game_Character existing = manager.findCharacter(newName);

        if (existing != null && existing != selected) {
            showError("That character name already exists.");
            return;
        }

        selected.setName(newName);

        refreshList();
        characterList.setSelectedValue(selected, true);
        updateStatus();

        log("Updated character name to: " + newName);
    }
}
