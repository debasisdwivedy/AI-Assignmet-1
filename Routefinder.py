import math

class Graph(object):
    
    def __init__(self, graph_dict={}):
        self.__graph_dict = graph_dict

    def find_vertex(self, vertex):
        if vertex not in self.__graph_dict:
            return "no"

    def add_vertex(self, vertex):
        if vertex not in self.__graph_dict:
            self.__graph_dict[vertex] = []
            
    def bfs(self, start_vertex, end_vertex, path=[]):
        #print start_vertex + "   " + end_vertex +'  '+path
        queue = [(start_vertex, [start_vertex])]
        print start_vertex
        while queue:
            (vertex, path) = queue.pop(0)
            for child in graph[vertex] - set(path):
                if child == end_vertex:
                    yield path + [child]
                else:
                    queue.append((child, path + [child]))
        return
    
    def dfs(self, start_vertex, end_vertex, path=[]):
        stack = [(start_vertex, [start_vertex])]
        while stack:
            (vertex, path) = stack.pop()
            for child in graph[vertex] - set(path):
                if child == end_vertex:
                    yield path + [child]
                else:
                    stack.append((child, path + [child]))
        return

    def a(self, start_vertex, end_vertex, path=[]):
        graph = self.__graph_dict
        path = path + [start_vertex]
        if start_vertex == end_vertex:
            return path
        if start_vertex not in graph:
            return None
        for vertex in graph[start_vertex]:
            if vertex not in path:
                extended_path = self.find_path(vertex, 
                                               end_vertex, 
                                               path)
                if extended_path: 
                    return extended_path
        return None
    
    def heuristic(self, vertex):
        #Calculate heuristic based on euclidean distance
        return 
    def add_edge(self, edge):
        edge = (edge)
        
        (vertex1, vertex2) = tuple(edge)
        if vertex1 in self.__graph_dict:
            self.__graph_dict[vertex1].append(vertex2)
        else:
            self.__graph_dict[vertex1] = [vertex2]
        if vertex2 in self.__graph_dict:
            self.__graph_dict[vertex2].append(vertex1)
        else:
            self.__graph_dict[vertex2] = [vertex1]

    def __generate_edges(self):
        edges = []
        for vertex in self.__graph_dict:
            for neighbour in self.__graph_dict[vertex]:
                edges.append({vertex, neighbour})
        return edges

    def __str__(self):
        res = "vertices: "
        for k in self.__graph_dict:
            res += str(k) + " "
        res += "\nedges: "
        for edge in self.__generate_edges():
            res += str(edge) + " "
        return res  
    
def GenerateGraphs(graph):
    #for x in road_list:
    #    print x[0],x[2]
    road_list=ReadRoads()
    #for i in range(len(road_list)):
        #graph[road_list[i][0]]=[road_list[i][2]]
    for i in road_list:
        graph.add_vertex(i[0])
        graph.add_vertex(i[2])
        try:
            graph.add_edge({i[0]+"_"+i[1],i[2]+"_"+i[3]})
        except:
            j=1
        #graph.add_edge({i[2],i[0]})
        
        #except:
        #    print i
        #graph={i[0]:i[2]}   
    #    graph[i[0]]=(i[2])
    
    #print graph
    
    #count=city.count["Sparta_Wisconsin"]
    #print len(graph.vertices())
    #print graph.vertices()
    
    #f = open('graph.txt', 'w')
    #try:
    #    f.write(graph.edges())
    #except:
    #    print graph.edges()
    #for x,j in graph:
    #    f.write(x + "\t" + j)
        
    #f.close()
    
    return graph   


def ReadCities():
    city_list=[i.strip() for i in open("/Users/Manikandan/Documents/Elements of AI/city.txt","r") ]
    
    city_lists=[[0 for i in range(4)] for i in range(len(city_list))] 
    
    j=0
    
    for i in city_list:
        city_list_temp=str(i).split()
        templist=city_list_temp[0].split(",")
        city_lists[j][0]=templist[0].replace("_"," ")
        city_lists[j][1]=templist[1].replace("_"," ").replace(" ","",1)  
        city_lists[j][2]=city_list_temp[1]
        city_lists[j][3]=city_list_temp[2]
        j=j+1
        
    """f = open('citylist.txt', 'w')
    
    for i in range(len(city_list)):
        for j in range(4):
            if(len(str(city_lists[i][j]))>8):
                f.write(str(city_lists[i][j])+"\t")
            else:
                f.write(str(city_lists[i][j])+"\t\t")
        f.write("\n")
        
    f.close()"""
    
    return city_lists

#Read the Road Segments from the file and input it into road_lists
def ReadRoads():
    
    road_list=[i.strip() for i in open("/Users/Manikandan/Documents/Elements of AI/road-segments.txt","r")]
    
    road_lists = [[0 for i in range(7)] for i in range(len(road_list))] 
    
    j=0
    
    for i in road_list:
        road_list_temp=str(i).split(",")
        road_lists[j][0]=road_list_temp[0].replace(" ","_")                         #City 1
        
        templist=road_list_temp[1].split()
        
        road_lists[j][1]=templist[0].replace(" ","_").replace("_","",1)             #City 1 State
        road_lists[j][2]=templist[1].replace(" ","_")                               #City 2
        templist2=road_list_temp[2].split()
        
        if(len(templist2))==4:
            road_lists[j][3]=templist2[0].replace(" ","_").replace("_","",1)        #City 2 State
            road_lists[j][4]=templist2[1]                                           #Distance
            road_lists[j][5]=templist2[2]                                           #Speed Limit
            road_lists[j][6]=templist2[3].replace(" ","_")                          #Highway
        elif(len(templist2))==3:
            road_lists[j][3]=templist2[0].replace(" ","_").replace("_","",1)        #City 2 State
            road_lists[j][4]=templist2[1]                                           #Distance
            road_lists[j][5]=0                                                      #Speed Limit
            road_lists[j][6]=templist2[2].replace(" ","_")                          #Highway
        j=j+1
    
    """"f = open('workfile.txt', 'w')
    
    for i in range(len(road_list)):
        for j in range(7):
            if(len(str(road_lists[i][j]))>8):
                f.write(str(road_lists[i][j])+"\t")
            else:
                f.write(str(road_lists[i][j])+"\t\t")
        f.write("\n")
        
    f.close()"""
    
    return road_lists

roads=ReadRoads()
cities=ReadCities()
g={}
graph=Graph(g)
gr=GenerateGraphs(graph)

path=graph.bfs("Boston_Massachusetts", "Binghamton_New_York")
route=raw_input("Enter Input \t:")
route=route.split()
if len(route)==4:
        startCity=route[0]
        #startState=raw_input("Start State\t:")
        destCity=route[1]
        #destState=raw_input("Destination State\t:")
        roption=route[2]
        ralgo=route[3]
        if(graph.find_vertex(startCity)=="No"):
            print "There is no such city called "+startCity
            print "Enter Valid Input"
        elif(graph.find_vertex(destCity)=="No"):
            print "There is no such city called "+destCity
            print "Enter Valid Input"
        else:    
            if ralgo[3]=="bfs":
                path=graph.bfs(startCity, destCity)
            elif ralgo[3]=="dfs":
                path=graph.dfs(startCity, destCity)
            elif ralgo[3]=="a*":
                path=graph.a(startCity, destCity)
            else:
                print "Wrong Algorithm. Choose Valid one"
            print path
else:
    print "Invalid Input"
