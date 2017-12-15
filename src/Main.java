import java.io.*;
import java.util.StringTokenizer;


public class Main {
	public static String taskName = "";

	public class Task {
		public void solve(int testNumber, InputReader in, PrintWriter out) {

		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		if(!taskName.isEmpty()) {
			System.setIn(new BufferedInputStream(new FileInputStream(taskName + ".in")));
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(taskName + ".out"))));
		}
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Main main = new Main();
		main.run(in, out);
		out.close();
	}

	public void run(InputReader in, PrintWriter out) {
		Task solver = new Task();
		solver.solve(1, in, out);
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while(tokenizer == null || !tokenizer.hasMoreTokens())
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch(IOException e) {
					throw new RuntimeException(e);
				}
			return tokenizer.nextToken();
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public double nextShort() {
			return Short.parseShort(next());
		}

		public double nextByte() {
			return Byte.parseByte(next());
		}

		public double nextFloat() {
			return Float.parseFloat(next());
		}
	}
}
