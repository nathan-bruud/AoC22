file = File.open("input.txt")
t = 0

def parse(str) 
    arr = str.split(",")
    a = arr[0]
    b = arr[1]
    aarr = a.split("-")
    barr = b.split("-")
    
    arange = (Integer(aarr[0])..Integer(aarr[1])).to_a
    brange = (Integer(barr[0])..Integer(barr[1])).to_a

    crange = (arange & brange)
    return crange == arange || crange == brange
end

file.each do |line|
    if (parse(line)) 
        t += 1
    end
    puts("Current count: #{t}")
end

