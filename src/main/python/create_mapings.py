import glob

start = '00000'
end = '00287'
ids = set()
mappings = {}

for path in glob.glob("/Users/fayimora/Desktop/coursework-2/out-201011-2/part*"):
    newfile = path + ".new"
    f = open(path)

    print "reading initial file"
    for line in f.readlines():
        n1, n2 = line.split(" ")
        ids.add(n1)
        ids.add(n2)
    f.close()

    print "Creating mapings"
    for i, id in enumerate(ids):
        mappings[id] = str(i)

    f = open(path)
    f2 = open(newfile, "aw")

    print "Saving mappings"
    for line in f.readlines():
        n1, n2 = line.split(" ")
        n1, n2 = mappings.get(n1), mappings.get(n2)
        f2.write(n1 + " " + n2 + "\n")

    f.close()
    f2.close()
