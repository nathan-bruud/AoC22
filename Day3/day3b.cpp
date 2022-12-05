#include <iostream>
#include <fstream>
#include <string>


int getScore(char toScore) {
    int val = toScore - 96;
    if (val < 0) {
        val = toScore - 38;
    }
    return val;
}

bool findIn(char toFind, std::string toSearch) {
    for (int i = 0; i < toSearch.length(); i++){
        if (toSearch[i] == toFind){
            return true;
        }
    }
    return false;
}

int scoreRuckSack(std::string pockets[3]) {
    int len = pockets[0].length();
    std::string left = pockets[0];
    std::cout << "Left is: "<< left << "\n";
    std::string center = pockets[1];
    std::cout << "Center is: "<< center << "\n";
    std::string right = pockets[2];
    std::cout << "Right is: "<< right << "\n";

    char shared;
    for (int i = 0; i < len; i++){
        if (findIn(left[i], right) && findIn(left[i], center)){
            shared = left[i];
        }
    }
    std::cout << "Shared is: "<< shared << "\n";

    int score = getScore(shared);
    std::cout << "This team's score is: " << score << "\n";
    return score;
}

int main() {
    std::ifstream myfile ("input.txt");
    std::string mystring;
    int runningScore = 0;
    int i = 0;
    std::string pockets[3];
    if (myfile.is_open()) { 
        while (myfile.good()) {
            myfile >> mystring; 
            if( myfile.eof() ) break;
            pockets[i] = mystring;
            if (i == 2){
                runningScore += scoreRuckSack(pockets);
                std::cout << "Running score is: " << runningScore << "\n\n";
                i = 0;
            } else {
                i++;
            }
            
        }
    }
    std::cout << runningScore << "\n"; 
}