package Misc;

import java.util.Arrays;
import java.util.List;

/**
 * Given a list of [FileName, FileSize, [Collection]] - Collection is optional, i.e., a collection
 * can have 1 or more files. Same file can be a part of more than 1 collection. How would you design
 * a system
 *
 * <p>To calculate total size of files processed. To calculate Top K collections based on size.
 * Example: file1.txt(size: 100) file2.txt(size: 200) in collection "collection1" file3.txt(size:
 * 200) in collection "collection1" file4.txt(size: 300) in collection "collection2" file5.txt(size:
 * 100)
 *
 * <p>Output: Total size of files processed: 900 Top 2 collections: - collection1 : 400 -
 * collection2 : 300
 */
public class FileProcessorTopCollection {
  public static void main(String[] args) {
    List<FileInfo> fileInfos =
        Arrays.asList(
            new FileInfo("file1", 100, null),
            new FileInfo("file2", 200, "collection1"),
            new FileInfo("file3", 200, "collection1"),
            new FileInfo("file4", 300, "collection2"),
            new FileInfo("file5", 100, null));
    System.out.println(calculateTotalSizeAndTopKCollections(fileInfos, 2));
  }

  public static String calculateTotalSizeAndTopKCollections(List<FileInfo> fileInfos, int k) {
    int size = 0;
      fileInfos.forEach(fileInfo -> {

      });
    return "";
  }

  private static class FileInfo {
    String fileName;
    int fileSize;
    String collection;

    FileInfo(String fileName, int fileSize, String collection) {
      this.fileName = fileName;
      this.fileSize = fileSize;
      this.collection = collection;
    }
  }
}
