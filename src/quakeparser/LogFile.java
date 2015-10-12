/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rulrok
 */
public class LogFile implements Iterable<String> {

    private File file;
    private List<String> lines;

    public LogFile(File log) throws FileNotFoundException {

        this.file = log;
        this._initializeList();

        Scanner reader = new Scanner(this.file);

        while (reader.hasNextLine()) {
            this.lines.add(reader.nextLine());
        }
    }

    public LogFile(String[] lines) {

        this._initializeList();

        this.lines.addAll(Arrays.asList(lines));

    }

    @Override
    public Iterator<String> iterator() {
        return this.lines.iterator();
    }

    private void _initializeList() {
        this.lines = new ArrayList<>();
    }

}
