def solve(s):
    name=s.split(" ")
    for i in range(len(name)):
        name[i]=name[i].capitalize()
    return " ".join(name)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = solve(s)

    fptr.write(result + '\n')

    fptr.close()