import random, copy

fin = open("data/kargerMinCut.txt")

G = {}
for line in fin: # load data, create adj lists
    line = line.strip()
    lst = line.split("\t")
    G[lst[0]] = lst[1:]


def chooseRandomEdge(G): #return an edge represented by 2 ints
    v1= G.keys() [random.randint(0,len(G)-1)]
    v2= G[v1] [random.randint(0,len(G[v1])-1)]
    return v1, v2


def kargerStep(G):
    v1,v2= chooseRandomEdge(G)
    #1. attach v2's list to v1
    G[v1].extend(G[v2])
    #2. replace all appearance of v2 as v1
    for x in G[v2]:
        lst=G[x]
        for i in range(0,len(lst)):
            if lst[i]==v2: lst[i]=v1        
    #3.remove self-loop
    while v1 in G[v1]:
        G[v1].remove(v1)
    #4. remove v2's list
    del G[v2]

def karger(G): 
    while len(G)>2: kargerStep(G)
    return len(G[G.keys()[0]])

min = karger(copy.deepcopy(G))
print min

for i in range(0,1000): # run many tests
    instance=karger(copy.deepcopy(G))
    if instance<min: min=instance
print 'Finally:',min
