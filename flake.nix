{
  description = "lets-build-a-simple-database (Java) dev shell";

  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs/nixpkgs-unstable";
  };

  outputs =
    { self, nixpkgs }:
    let
      system = "aarch64-darwin";
      pkgs = import nixpkgs { inherit system; };
      jdk = pkgs.jdk25;
    in
    {
      devShells.${system}.default = pkgs.mkShell {
        packages = [
          jdk
          (pkgs.gradle_9.override { java = jdk; })
        ];

        shellHook = ''
          export JAVA_HOME=${jdk.home}
          echo "dev shell"
          echo "  java   : $(java -version 2>&1 | head -1)"
          echo "  gradle : $(gradle --version 2>/dev/null | grep '^Gradle')"
        '';
      };
    };
}
