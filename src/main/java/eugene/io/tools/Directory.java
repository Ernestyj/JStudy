package eugene.io.tools;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by DCLab on 10/28/2015.
 */
public final class Directory {

    public static File[] local(File dir, final String regex){
        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.compile(regex).matcher(new File(name).getName()).matches();
            }
        });
    }
    public static File[] local(String dirPath, final String regex){
        return local(new File(dirPath), regex);
    }

    public static TreeInfo walk(String start, String regex){
        return recurseDirs(new File(start), regex);
    }
    public static TreeInfo walk(File start, String regex){
        return recurseDirs(start, regex);
    }
    public static TreeInfo walk(String start){
        return recurseDirs(new File(start), ".*");
    }

    private static TreeInfo recurseDirs(File startDir, String regex){
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()){
            if (item.isDirectory()){
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else if (item.getName().matches(regex)) result.files.add(item);
        }
        return result;
    }

    public static class TreeInfo implements Iterator<File>{
        List<File> files = new ArrayList<>();
        List<File> dirs = new ArrayList<>();

        public Iterator<File> iterator(){
            return files.iterator();
        }

        public void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public File next() {
            return null;
        }

        @Override
        public String toString() {
            return "dirs: " + Print.format(dirs) +
                    "\n\nfiles: " + Print.format(files);
        }
    }
}
