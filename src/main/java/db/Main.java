package db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

enum MetaCommandResult {
	META_COMMAND_SUCCESS, META_COMMAND_UNRECOGNIZED_COMMAND
}

enum StatementType {
	STATEMENT_INSERT, STATEMENT_SELECT
}

enum PrepareResult {
	PREPARE_SUCCESS, PREPARE_UNRECOGNIZED_STATEMENT
}

record Statement(StatementType type) {
}

record PrepareStatement(PrepareResult prepareResult, Statement statement) {
}

public class Main {
	public void main() {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(isr);

			while (true) {
				System.out.print("db > ");
				String input = reader.readLine();

				if (input == null)
					break;

				if (input.startsWith(".")) {
					switch (doMetaCommand(input)) {
						case META_COMMAND_SUCCESS:
							continue;
						case META_COMMAND_UNRECOGNIZED_COMMAND:
							System.out.println(String.format("Unrecognized command '%s'",
									input));
							continue;
					}
				}

				PrepareStatement prepareStatement = prepareStatement(input);

				switch (prepareStatement.prepareResult()) {
					case PREPARE_SUCCESS:
						break;
					case PREPARE_UNRECOGNIZED_STATEMENT:
						System.out.println(String.format("Unrecognized keyword at start of '%s'.", input));
						continue;
				}

				executeStatement(prepareStatement.statement());
				System.out.println("Executed.");
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private void executeStatement(Statement statement) {
		switch (statement.type()) {
			case STATEMENT_INSERT:
				System.out.println("This is where we would do an insert.");
				break;
			case STATEMENT_SELECT:
				System.out.println("This is where we would do a select.");
				break;
		}
	}

	private MetaCommandResult doMetaCommand(String input) {
		if (input.equals(".exit"))
			System.exit(0);

		return MetaCommandResult.META_COMMAND_UNRECOGNIZED_COMMAND;
	}

	private PrepareStatement prepareStatement(String input) {
		if (input.startsWith("insert"))
			return new PrepareStatement(PrepareResult.PREPARE_SUCCESS, new Statement(StatementType.STATEMENT_INSERT));

		if (input.equals("select"))
			return new PrepareStatement(PrepareResult.PREPARE_SUCCESS, new Statement(StatementType.STATEMENT_SELECT));

		return new PrepareStatement(PrepareResult.PREPARE_UNRECOGNIZED_STATEMENT, null);

	}

}
