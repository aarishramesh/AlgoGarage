package stack;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyDirectoryPath {
	
	public static void main(String[] args) {
		System.out.println(simplify("/abcd/asc/.././../a/"));
	}
	public static String simplify(String A) {
		StringBuilder builder = new StringBuilder();
		if (!A.isEmpty() && A != null) {
			String[] directory = A.split("/");
			Deque<String> foldersStack = new LinkedList<String>();
			
			for (String folder : directory) {
				if (folder.equals("..")) {
					if (!foldersStack.isEmpty())
						foldersStack.pop();
				} else if (folder.equals(".") || folder.equals("")) {
					continue;
				} else
					foldersStack.push(folder);
			}
			builder.append("/");
			while (!foldersStack.isEmpty()) {
				builder.append(foldersStack.removeLast());
				if (!foldersStack.isEmpty())
					builder.append("/");
			}
		}
		return builder.toString();
	}
}
