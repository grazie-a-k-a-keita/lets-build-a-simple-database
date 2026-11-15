## Let's Build a Simple Database (Java)

[cstack/db_tutorial](https://cstack.github.io/db_tutorial/)（C言語で SQLite のようなデータベースを作るチュートリアル）を、Java で実装し直す学習用リポジトリ。

### 必要なもの

- [Nix](https://nixos.org/)（flakes 有効）
- [direnv](https://direnv.net/)

JDK 25 と Gradle 9 は `flake.nix` の devShell で入る。初回だけ次を実行する。

```bash
direnv allow
```

以降はこのディレクトリに `cd` すると自動で環境に入る。

### コマンド

```bash
# 起動
gradle -q --console=plain run

# テスト
gradle test

# 配布用ビルドと実行
gradle installDist
./build/install/simple-db/bin/simple-db

# 入力をパイプで流して試す
printf 'hello\n.exit\n' | gradle -q --console=plain run
```

### 進捗

- [x] [Part 1 - Introduction and Setting up the REPL](https://cstack.github.io/db_tutorial/parts/part1.html)
- [ ] [Part 2 - World's Simplest SQL Compiler and Virtual Machine](https://cstack.github.io/db_tutorial/parts/part2.html)
- [ ] [Part 3 - An In-Memory, Append-Only, Single-Table Database](https://cstack.github.io/db_tutorial/parts/part3.html)
- [ ] [Part 4 - Our First Tests (and Bugs)](https://cstack.github.io/db_tutorial/parts/part4.html)
- [ ] [Part 5 - Persistence to Disk](https://cstack.github.io/db_tutorial/parts/part5.html)
- [ ] [Part 6 - The Cursor Abstraction](https://cstack.github.io/db_tutorial/parts/part6.html)
- [ ] [Part 7 - Introduction to the B-Tree](https://cstack.github.io/db_tutorial/parts/part7.html)
- [ ] [Part 8 - B-Tree Leaf Node Format](https://cstack.github.io/db_tutorial/parts/part8.html)
- [ ] [Part 9 - Binary Search and Duplicate Keys](https://cstack.github.io/db_tutorial/parts/part9.html)
- [ ] [Part 10 - Splitting a Leaf Node](https://cstack.github.io/db_tutorial/parts/part10.html)
- [ ] [Part 11 - Recursively Searching the B-Tree](https://cstack.github.io/db_tutorial/parts/part11.html)
- [ ] [Part 12 - Scanning a Multi-Level B-Tree](https://cstack.github.io/db_tutorial/parts/part12.html)
- [ ] [Part 13 - Updating Parent Node After a Split](https://cstack.github.io/db_tutorial/parts/part13.html)
- [ ] [Part 14 - Splitting Internal Nodes](https://cstack.github.io/db_tutorial/parts/part14.html)
- [ ] [Part 15 - Where to go next](https://cstack.github.io/db_tutorial/parts/part15.html)
