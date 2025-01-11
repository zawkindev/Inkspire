{ pkgs ? import <nixpkgs> { } }:
pkgs.mkShell {
  buildInputs = with pkgs;[
    openjdk21
    maven
    lombok
  ];
  shellHook = ''
    echo "Java 21 and Maven are ready to use!"
    java -version
    mvn --version
    echo lombok: {$pkgs.lombok}
  '';
}
