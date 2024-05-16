package com.experiments.experiment08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class IOTest {
    public static void main(String[] args) {
        String fileName = "C:/example/from.txt";

        System.out.println("----- 创建文件 ------");
       // createFile(fileName);

        System.out.println("-----  将字符串写入文件 -------");
        // \r\n在txt文本中换行
        String str =
                "白日依山尽\r\n" +
                        "黄河入海流\r\n" +
                        "欲穷千里目\r\n" +
                        "更上一层楼\r\n";
        //writeToFile(fileName, str);
        //writeToFile2(fileName, str);

        System.out.println("--------- 基于基本IO流实现文件的复制 ----------");
        String toFile = "C:/example/to.txt";
        // copyByIO(fileName, toFile);

        System.out.println("--------- 基于NIO实现文件的复制 ----------");
        String toFile2 = "C:/example/nio/to.txt";
        // copyByNIO(fileName, toFile2);

        System.out.println("---------- 删除指定文件 -------------");
        // deleteFile(toFile);

        System.out.println("---------- 遍历指定目录文件 -------------");
        String dir = "C:/example";
         walkDirectories(dir);
    }

    /**
     * 基于Path/Files实现
     * 将传入的文件绝对路径字符串转path
     * 判断path不存在，则先创建目录，创建文件
     * 文件存在，忽略操作
     *
     * @param fileName
     */
    private static void createFile(String fileName) {
        try {
            Path filePath = Path.of(fileName);
            if (!Files.exists(filePath)) {
                Files.createDirectories(filePath.getParent());
                Files.createFile(filePath);
                System.out.println("文件创建成功：" + fileName);
            } else {
                System.out.println("文件已存在，无需创建：" + fileName);
            }
        } catch (IOException e) {
            System.err.println("文件创建失败：" + e.getMessage());
        }
    }


    /**
     * 注意，传入的fileName为文件绝对路径，必须确保文件所在目录已经存在，才能通过FileOutputStream创建
     * 将字符串转字节数组，基于FileOutputStream直接写入
     *
     * @param fileName
     * @param content
     */
    private static void writeToFile(String fileName, String content) {
        try {
            Files.write(Path.of(fileName), content.getBytes());
            System.out.println("字符串成功写入文件：" + fileName);
        } catch (IOException e) {
            System.err.println("写入文件失败：" + e.getMessage());
        }
    }


    /**
     * 将传入的文件绝对路径字符串转path，通过Files创建文件所在目录
     * 将字符串，基于Files工具类直接写入。写入方法，文件不存在创建并写入，存在则覆盖写入
     * 字符串转字节数组再写入也可，但无意义
     *
     * @param fileName
     * @param content
     */
    private static void writeToFile2(String fileName, String content) {
        try {
            Files.writeString(Path.of(fileName), content);
            System.out.println("字符串成功写入文件：" + fileName);
        } catch (IOException e) {
            System.err.println("写入文件失败：" + e.getMessage());
        }
    }


    /**
     * 基于基本IO，以及字节数组缓冲区，复制文件
     * 打印显示循环读写循环次数
     * 正确关闭资源
     *
     * @param sourceFile
     * @param targetFile
     */
    private static void copyByIO(String sourceFile, String targetFile) {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(targetFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            int totalBytesRead = 0;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
            }
            System.out.println("文件复制成功，共复制了 " + totalBytesRead + " 字节。");
        } catch (IOException e) {
            System.err.println("文件复制失败：" + e.getMessage());
        }
    }


    /**
     * 基于NIO，实现文件的复制
     * 注意，判断目标为字符串，需要转为path并创建相应目录
     *
     * @param sourceFile
     * @param targetFile
     */
    private static void copyByNIO(String sourceFile, String targetFile) {
        try {
            Path sourcePath = Path.of(sourceFile);
            Path targetPath = Path.of(targetFile);
            Files.createDirectories(targetPath.getParent());
            Files.copy(sourcePath, targetPath);
            System.out.println("文件复制成功：" + sourceFile + " -> " + targetFile);
        } catch (IOException e) {
            System.err.println("文件复制失败：" + e.getMessage());
        }
    }


    /**
     * 删除文件
     *
     * @param fileName
     */
    private static void deleteFile(String fileName) {
        try {
            Files.delete(Path.of(fileName));
            System.out.println("文件删除成功：" + fileName);
        } catch (IOException e) {
            System.err.println("文件删除失败：" + e.getMessage());
        }
    }


    /**
     * 遍历打印指定目录下全部目录/文件名称
     * 尝试改变正逆序操作方法
     *
     * @param dir
     */
    private static void walkDirectories(String directory) {
        try {
            Files.walkFileTree(Path.of(directory), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("文件：" + file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("目录：" + dir);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println("访问文件失败：" + file);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.err.println("遍历目录失败：" + e.getMessage());
        }
    }
}
