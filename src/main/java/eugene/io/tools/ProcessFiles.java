package eugene.io.tools;

import java.io.File;
import java.io.IOException;

/**文件处理（策略模式）
 * Created by DCLab on 10/28/2015.
 */
public class ProcessFiles {

    public static void main(String[] args){
        new ProcessFiles(new ProcessFiles.Strategy(){
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, "iml").start(new String[]{"."});
    }

    public interface Strategy{
        void process(File file);
    }

    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext){
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] filePaths){
        try {
            if (filePaths.length == 0) processDirectoryTree(new File("."));
            else for (String filePath : filePaths){
                File fileArg = new File(filePath);
                if (fileArg.isDirectory()) processDirectoryTree(fileArg);
                else {
                    if (!filePath.endsWith("." + ext)) filePath += "." + ext;
                    strategy.process(new File(filePath).getCanonicalFile());
                }
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private void processDirectoryTree(File root) throws IOException{
        for (File file : Directory.local(root.getAbsolutePath(), ".*\\." + ext))
            strategy.process(file.getCanonicalFile());
    }
}
