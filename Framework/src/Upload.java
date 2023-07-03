package etu2051.framework;

public class Upload {
    String filename;
    String path; 
    byte[] data;
    public void set_filename(String filename) {
        this.filename = filename;
    }
    public void set_path(String path) {
        this.path = path;
    }
    public void set_data(byte[] data) {
        this.data = data;
    }
    public String get_filename() {
        return filename;
    }
    public String get_path() {
        return path;
    }
    public byte[] get_data() {
        return data;
    }
}
