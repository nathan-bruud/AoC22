
package main

import (
	"fmt"
	"os"
	"path"
	"strings"
)

func mainb() {
	input, _ := os.ReadFile("input.txt")

	fs, cd := map[string]int{}, ""
	for _, s := range strings.Split(strings.TrimSpace(string(input)), "\n") {
		var size int
		var name string

		if strings.HasPrefix(s, "$ cd") {
			cd = path.Join(cd, strings.Fields(s)[2])
		} else if _, err := fmt.Sscanf(s, "%d %s", &size, &name); err == nil {
			for d := cd; d != "/"; d = path.Dir(d) {
				fs[d] += size
			}
			fs["/"] += size
		}
	}

	sum := 0
	for _, s := range fs {

		if s+70000000 >= 30000000 && s < sum {
			sum = s
		}
	}
	fmt.Println(sum)
}