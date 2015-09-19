def main():
    open=[]
 #   open.append([])
#    open.append([])
#    open.append([])
#    open.append([])
#    open.append([])
    closed=[]
 #   closed.append([])
#    closed.append([])
#    closed.append([])
#    closed.append([])
#    closed.append([])
 #   x=[]
 #   x.append([])
#    x.append([])
#    x.append([])
#    x.append([])
    intialState=[]
#    initialState.append([])
#    initialState.append([])
#    initialState.append([])
#    initialState.append([])
    intialState.append([[5,7,8,1],[10,2,4,3],[6,9,11,12],[15,13,14,16]])
    goalState=[]
#    goalState.append([])
#    goalState.append([])
#    goalState.append([])
#    goalState.append([])
    goalState.append([[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]])
    tempState=[]
    f=[]
    h=[]
    g=[]
    fclosed=[]
    hclosed=[]
    gclosed=[]
    fopen=[]
    hopen=[]
    gopen=[]
    i=0
    child=[]
 #   child.append([])
#    child.append([])
#    child.append([])
#    child.append([])
    counter1=0
    j=0
    k=0
    l=0
    a=0
 #   tempChild=[]
#    tempChild.append([])
#    tempChild.append([])
#    tempChild.append([])
#    tempChild.append([])
    depth=0
    path=[]
    openPath=[]
    childPath=[]
    open.append(intialState)
    path.append('s ')
    print"hello"
    while (open.count != 0):
        x=open[0][0]
        if x==goalState:
            while (open.count !=0):
                for i in range(len(open)-1):
                    tempState=open[i+1]
                    if (tempState==goalState and f[i+1]<f[i]):
                        x=open[i+1]
            print path
            return path 
        else:
            #generate children for X
            depth=depth+1
            #tempElement=x[0][0]
            child.append([[x[0][3],x[0][0],x[0][1],x[0][2]],
                      [x[1][0],x[1][1],x[1][2],x[1][3]],
                      [x[2][0],x[2][1],x[2][2],x[2][3]],
                      [x[3][0],x[3][1],x[3][2],x[3][3]]])
            child[0].append('r1 ')
            
            child.append([[x[0][0],x[0][1],x[0][2],x[0][3]],
                      [x[1][3],x[1][0],x[1][1],x[1][2]],
                      [x[2][0],x[2][1],x[2][2],x[2][3]],
                      [x[3][0],x[3][1],x[3][2],x[3][3]]])
            child[1].append('r2 ')
            
            child.append([[x[0][0],x[0][1],x[0][2],x[0][3]],
                      [x[1][0],x[1][1],x[1][2],x[1][3]],
                      [x[2][3],x[2][0],x[2][1],x[2][2]],
                      [x[3][0],x[3][1],x[3][2],x[3][3]]])
            child[2].append('r3 ')
        
            child.append([[x[0][0],x[0][1],x[0][2],x[0][3]],
                      [x[1][0],x[1][1],x[1][2],x[1][3]],
                      [x[2][0],x[2][1],x[2][2],x[2][3]],
                      [x[3][3],x[3][0],x[3][1],x[3][2]]])
            child[3].append('r4 ')
        
            child.append([[x[3][0],x[0][1],x[0][2],x[0][3]],
                      [x[0][0],x[1][1],x[1][2],x[1][3]],
                      [x[1][0],x[2][1],x[2][2],x[2][3]],
                      [x[2][0],x[3][1],x[3][2],x[3][3]]])
            child[4].append('d1 ')
        
            child.append([[x[0][0],x[3][1],x[0][2],x[0][3]],
                      [x[1][0],x[0][1],x[1][2],x[1][3]],
                      [x[2][0],x[1][1],x[2][2],x[2][3]],
                      [x[3][0],x[2][1],x[3][2],x[3][3]]])
            child[5].append('d2 ')
        
            child.append([[x[0][0],x[0][1],x[3][2],x[0][3]],
                      [x[1][0],x[1][1],x[0][2],x[1][3]],
                      [x[2][0],x[2][1],x[1][2],x[2][3]],
                      [x[3][0],x[3][1],x[2][2],x[3][3]]])
            child[6].append('d3 ')
        
            child.append([[x[0][0],x[0][1],x[0][2],x[3][3]],
                      [x[1][0],x[1][1],x[1][2],x[0][3]],
                      [x[2][0],x[2][1],x[2][2],x[1][3]],
                      [x[3][0],x[3][1],x[3][2],x[2][3]]])
            child[7].append('d4 ')

            for j in range(7):
                tempChild=child[j]
                counter2=0
                
                for k in range(3):
                        for l in range(3):
                            if (tempChild[k][l]!=intialState[k][l]):
                                counter2=counter2 + 1               
            childPath[j]=openPath[0].append(child.pop(child.index(tempChild)))                
            h[j]=counter2
            g[j]=depth
            f[j]=g[j]+h[j]
            if (not(tempChild in open) and (not(tempChild in closed))):
                #open.append([])
                #open.append([])
                #open.append([])
                #open.append([])
                #open.append([])
                openPath.append(childPath[j])
                open.append(tempChild)
                
                        #add heuristic to the child

            if (tempChild in open):
                    index = open.index(tempChild)
                    if(fopen[index]>f[j]):
                        fopen[index]=f[j]
                        gopen[index]=g[j]
                        hopen[index]=h[j]
                        openPath[index]=childPath[j]
                    
                        

            if(tempChild in closed):
                        index=closed.index(tempChild)
                        if(fclosed(index)<f(j)):
                            closed.remove(tempChild)
                            path.remove(path[index])
                            fclosed.pop(index)
                            gclosed.pop(index)
                            hclosed.pop(index)
                            open.append(tempChild)
                            openPath.append(childPath[j])
                            fopen.append(f[j])
                            gopen.append(g[j])
                            hopen.append(h[j])
    
                    
    
        
        
    closed.append(x)
    path.append(openPath)
    open.pop(0)
    fclose.append(fopen[0])
    fopen.pop(0)
    gclose.append(gopen[0])
    gopen.pop(0)
    hclose.append(hopen[0])
    hopen.pop(0)
    

    for a in range(len(hopen)-1):
        if(hopen(a)>hopen(a+1)):
            hopentemp=0
            gopentemp=0
            fopentemp=0
            opentemp=[]
            openPathTemp=[]
            hopentemp=hopen[a]
            gopentemp=gopen[a]
            fopentemp=fopen[a]
            opentemp=open[a]
            openPathTemp=openPath[a]
            hopen[a]=hopen[a+1]
            gopen[a]=gopen[a+1]
            fopen[a]=fopen[a+1]
            open[a]=open[a+1]
            openPath[a]=openPath[a+1]
            hopen[a+1]=hopentemp
            gopen[a+1]=gopentemp
            fopen[a+1]=fopentemp
            open[a+1]=opentemp
            openPath[a+1]=openPathTemp

    print "fail"
    return fail;
            
main()
    
    


