import 'dart:io';

List<List<String>> towers = [
  ['D', 'T', 'W', 'F', 'J', 'S', 'H', 'N'],
  ['H', 'R', 'P', 'Q', 'T', 'N', 'B', 'G'],
  ['L', 'Q', 'V'],
  ['N', 'B', 'S', 'W', 'R', 'Q'],
  ['N', 'D', 'F', 'T', 'V', 'M', 'B'],
  ['M', 'D', 'B', 'V', 'H', 'T', 'R'],
  ['D', 'B', 'Q', 'J'],
  ['D', 'N', 'J', 'V', 'R', 'Z', 'H', 'Q'],
  ['B', 'N', 'H', 'M', 'S']
];

void main() {
  File x = new File('./input.txt');
  List<String> file = x.readAsLinesSync();
  file.forEach((l) => move(l));
  printOutput();
}

void move(String directions) {
  final output = directions.split(' ');
  int number = int.parse(output[1]);
  int source = int.parse(output[3]) - 1;
  int dest = int.parse(output[5]) - 1;
  for (int i = 0; i < number; i++) {
    towers[dest].add(towers[source].removeLast());
  }
}

void printOutput() {
  for (final x in towers) {
    print(x);
  }
}
