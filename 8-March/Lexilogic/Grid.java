/*
 * Grid.java
 * Casey Barajas
 * 3/6/2024
 * 
 * This file contains the Grid class for the Lexilogic game. The Grid class is responsible for keeping track of the
 * cells in the grid and the hints that have been revealed.
 * 
 * The grid is like the grid in the Matrix. It is the grid of life. It is the grid of the Lexilogic game. It is the
 * grid of the Lexilogic game. It is the grid of the Lexilogic game. It is the grid of the Lexilogic game. It is the
 * grid of the Lexilogic game. It is the grid of the Lexilogic game. It is the grid of the Lexilogic game. It is the
 * grid of the Lexilogic game. It is the grid of the Lexilogic game. It is the grid of the Lexilogic game. It is the
 * 
 * The matrix sounds fun in theory but like in reality its just a bunch of 1s and 0s. Its just a bunch of code. Its
 * yeah
 * 
 * Why did the chicken cross the road
 * To get to the other side
 * *bah dum tss*
 * 
 * thanks for coming to my comedy show
 * 
 */

import java.util.ArrayList;

public class Grid {
    private ArrayList<Cell> cells; // list of cells
    private ArrayList<String> revealedHints; // list of revealed hints
    private Cell[][] grid; // 2D array of cells
    
    public Grid() {
        cells = new ArrayList<>(); // initialize cells list
        cells.add(new Cell("CPU", "The component in C2 is a type of volatile memory that the CPU uses", "A1")); // add cells to the list
        cells.add(new Cell("RAM", "The component in E4 is the main circuit board that holds the CPU and RAM", "C2"));
        cells.add(new Cell("Motherboard", "The component in A4 is responsible for rendering graphics", "E4"));
        cells.add(new Cell("GPU", "The component in D2 is a video output interface", "A4"));
        cells.add(new Cell("SSD", "The component in C4 is an older and slower type of non-volatile storage", "A5"));
        cells.add(new Cell("Power Supply", "The component in A5 provides power to all the components in the computer", "A6"));
        cells.add(new Cell("Heatsink", "The component in F2 helps dissipate heat from the CPU", "B1"));
        cells.add(new Cell("Fan", "The component in C5 helps cool the inside of the computer case", "B2"));
        cells.add(new Cell("Thermal Paste", "The component in B1 is used to apply this substance to the CPU", "B3"));
        cells.add(new Cell("BIOS", "The component in F3 is a type of non-volatile memory that stores firmware settings", "B4"));
        cells.add(new Cell("USB Port", "The component in B6 is used for wired internet connections", "B5"));
        cells.add(new Cell("Ethernet Port", "The component in C3 is a type of optical drive", "B6"));
        cells.add(new Cell("Wireless Card", "The component in F5 is the same type of wireless networking device", "C1"));
        cells.add(new Cell("Optical Drive", "The component in B6 is a wired connection for internet or local networks", "C3"));
        cells.add(new Cell("Hard Drive", "The component in A5 has faster read/write speeds than this component", "C4"));
        cells.add(new Cell("NVMe SSD", "The component in B2 is a type of high-speed solid-state drive", "C5"));
        cells.add(new Cell("Sound Card", "The component in D1 can be installed in a PCI or PCIe slot", "C6"));
        cells.add(new Cell("Expansion Card", "The component in C6 is used for audio input and output", "D1"));
        cells.add(new Cell("HDMI Port", "The component in A4 is another method for connecting a display", "D2"));
        cells.add(new Cell("DisplayPort", "The component in D4 is a high-speed external connection standard", "D3"));
        cells.add(new Cell("Thunderbolt Port", "The component in D3 is a video output interface like HDMI", "D4"));
        cells.add(new Cell("Firewire Port", "The component in D6 provides power to the BIOS when the computer is off", "D5"));
        cells.add(new Cell("CMOS Battery", "The component in D5 is an older high-speed external connection standard", "D6"));
        cells.add(new Cell("Coaxial Port", "The component in F6 is used for high-speed network connections", "E1"));
        cells.add(new Cell("L1 Cache", "The component in F3 is a type of cache memory", "E2"));
        cells.add(new Cell("Northbridge", "The component in E5 is part of the chipset along with the Northbridge", "E3"));
        cells.add(new Cell("Southbridge", "The component in E3 is part of the chipset that interfaces with I/O devices", "E5"));
        cells.add(new Cell("L2 Cache", "The component in E2 is a larger but slower cache than the L1 cache", "E6"));
        cells.add(new Cell("Microphone Jack", "The component in F2 can be used for audio output", "F1"));
        cells.add(new Cell("Speaker Jack", "The component in B1 is used with the CPU to dissipate heat", "F2"));
        cells.add(new Cell("CMOS", "The component in B4 is a type of non-volatile memory that stores firmware settings", "F3"));
        cells.add(new Cell("DVD Drive", "The component in C3 is another type of optical drive", "F4"));
        cells.add(new Cell("Wi-Fi Adapter", "The component in C1 is a type of wireless networking device", "F5"));
        cells.add(new Cell("Fiber Optic Port", "The component in E1 can be used for audio/video or internet connections", "F6"));

        revealedHints = new ArrayList<>();
        grid = new Cell[6][6];
        
        // Fill 2D array
        for (Cell cell : cells) {
            String placement = cell.showPlacement();
            char row = placement.charAt(0);
            int col = Integer.parseInt(placement.substring(1));
            grid[row-'A'][col-1] = cell;
        }
        
        // Mark the first cell (Java) as solved
        grid[0][0].markSolved();
        revealedHints.add(grid[0][0].showHint());
    }
    
    public void printGrid() {
        System.out.println("    1         2         3         4         5         6    ");
        System.out.println("  +---------+---------+---------+---------+---------+---------+");
        
        for (int i = 0; i < 6; i++) {
            System.out.print((char)('A' + i) + " | ");
            for (int j = 0; j < 6; j++) {
                Cell cell = grid[i][j];
                if (cell != null && cell.isSolved()) {
                    String word = cell.showWord();
                    System.out.print(word + " ".repeat(Math.max(0, 9 - word.length())) + "| ");
                } else {
                    System.out.print("         | ");
                }
            }
            System.out.println();
            System.out.println("  +---------+---------+---------+---------+---------+---------+");
        }
    }
    
        // method to solve a cell by providing its location and a guess
        public boolean solveCell(String location, String guess) {
            if (!checkSpace(location)) { // check if the location is valid
                return false;
            }
            
            char row = location.charAt(0);
            int col = Integer.parseInt(location.substring(1));
            Cell cell = grid[row-'A'][col-1];
            
            if (cell.showWord().equalsIgnoreCase(guess)) { // check if the guess is correct
                cell.markSolved(); // mark the cell as solved
                revealedHints.add(cell.showHint()); // add the hint to the revealed hints list
                return true;
            } 
            return false;
        }
        
        // method to print all the revealed hints
        public void printHints() {
            System.out.println("Hints:");
            for (String hint : revealedHints) {
                System.out.println(hint);
            }
        }
        
        // method to print the last revealed hint
        public void printLastHint() {
            if (!revealedHints.isEmpty()) {
                System.out.println("Last hint: " + revealedHints.get(revealedHints.size()-1));
            } else {
                System.out.println("No hints have been revealed yet.");
            }
        }

        // method to check if a cell at a specific row and column is solved
        public boolean isSolved(int row, int col) {
            return grid[row][col].isSolved();
        }
        
        // method to get the cell at a specific row and column
        public Cell getCell(int row, int col) {
            return grid[row][col];
        }
        
        // method to check if a location is a valid space on the grid
        public boolean checkSpace(String location) {
            if (location.length() != 2) {
                System.out.println("Invalid input. Use format like 'A1'.");
                return false;
            }

            char row = location.charAt(0);
            int col = Integer.parseInt(location.substring(1));
            
            if (row < 'A' || row > 'F' || col < 1 || col > 6) {
                System.out.println("Invalid location. Use format like 'A1'.");
                return false; 
            }
            return true;
        }
        
        // method to check if the entire grid is solved
        public boolean isSolved() {
            for (Cell[] cellRow : grid) {
                for (Cell cell : cellRow) {
                    if (cell != null && !cell.isSolved()) {
                        return false;
                    }
                }
            }
            return true; 
        }
    }
