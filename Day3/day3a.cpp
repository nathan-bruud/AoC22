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

int scoreRuckSack(std::string pockets) {
    int len = pockets.length();
    int sublen = len / 2;
    std::string left = pockets.substr(0, sublen);
    std::cout << "Left is: "<< left << "\n";
    std::string right = pockets.substr(sublen, sublen);
    std::cout << "Right is: "<< right << "\n";

    char shared;
    for (int i = 0; i < sublen; i++){
        if (findIn(left[i], right)){
            shared = left[i];
        }
    }
    std::cout << "Shared is: "<< shared << "\n";

    int score = getScore(shared);
    std::cout << "This sack's score is: " << score << "\n";
    return score;
}

int main() {
    std::ifstream myfile ("input.txt");
    std::string mystring;
    int runningScore = 0;
    if (myfile.is_open()) { 
        while (myfile.good()) {
            myfile >> mystring; 
            if( myfile.eof() ) break;
            runningScore += scoreRuckSack(mystring);
            std::cout << "Running score is: " << runningScore << "\n\n";
            
        }
    }
    std::cout << runningScore << "\n"; 
}