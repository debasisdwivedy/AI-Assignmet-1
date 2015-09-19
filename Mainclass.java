import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Irene received maxwell street
Frank received Doorknob
Heather received package for Orange Drive
Jerry received heathers package
George received maxwell street

P——> { Irene, Frank, George, Heather, Jerry}
I——>  { Candelabrum, Banister, Doorknob, Elephant, Amplifier}
A——> { Kirkwood, Lake avenue, Orange Drive, North Avenue, Maxwell Street}

HASH MAP——>
{Frank doorknob}
{Heather orange drive}
{Jerry heather}
{person(cand) ban}
{person(ban) irene}
{person(kirkwood) George}
{person(lake avenue) kirkwood}
{person(north avenue) Elephant}
{person(elephant) Maxwell street}
{person(maxwell street) Amplifier}

Person			Ordered(person.item)		Item Got(persongotitem)			   Address(person.address)
————-			————							————			               —————-
Irene			{cand,door,else,amp}				                          {kirkwood, LA,OD,NA,MS}                   

Frank	        {cand,ban,ele,amp}			Doorknob                          {kirkwood, LA,OD,NA,MS}

Heather			{cand,ban,door,ele,amp}		Orange Drive                      {kirkwood, LA,NA,MS}        

Jerry			{cand,ban,door,ele,amp}		Heather Package                   {kirkwood, LA,OD,NA,MS}            

George	        {cand,ban,door,ele,amp}      				                  {kirkwood, LA,OD,NA,MS}		                 

Person			Cand						Banister

Person			Banister					Irene

											George		      	                  Kirkwood

											Kirkwood			                 Lake avenue

											Elephant			                 North avenue

Person			Elephant					Maxwell Street

											Amplifier			                 Maxwell street
											


Algorithm
———————————
for irene {cand ; kirkwood}
for frank {remove Irene list}
for Heather(remove irene and frank list)
for jerry(remove iren, frank and heather list)
for George(remove irene, frank, heather and george)

CHECK CONDITIONS

close loops
 */


public class Mainclass {
	
public static void main(String[] args)
{
System.out.println("Begin");
List<String> person= new ArrayList<String>();
person.add("Irene");
person.add("Frank");
person.add("George");
person.add("Heather");
person.add("Jerry");

List<String> item= new ArrayList<String>();
item.add("Candelabrum");
item.add("Banister");
item.add("Doorknob");
item.add("Elephant");
item.add("Amplifier");

List<String> address= new ArrayList<String>();
address.add("Kirkwood");
address.add("Lake avenue");
address.add("Orange Drive");
address.add("North Avenue");
address.add("Maxwell Street");

/*
 * check if key is a person in the list
 * if a person, then he got the value as an item or item to that address and remove item or address from his looping list
 * if a address or item, check the person with that item or address and remove the value from his list in the loop.
 */

HashMap<String, String> conditions= new HashMap();
conditions.put("Heather", "Orange Drive");
conditions.put("Jerry","Heather");
conditions.put("Candelabrum","Banister");
conditions.put("Banister","Irene");
conditions.put("Kirkwood","George");
conditions.put("Lake avenue","Kirkwood");
conditions.put("North avenue","Elephant");
conditions.put("Elephant","Maxwell Street");
conditions.put("Maxwell Street","Amplifier");

/*
 * IRENE
 */
List<String> ireneItem= new ArrayList<String>();
ireneItem.add("Candelabrum");
ireneItem.add("Banister");
ireneItem.add("Doorknob");
ireneItem.add("Elephant");
ireneItem.add("Amplifier");

List<String> ireneAddress= new ArrayList<String>();
ireneAddress.add("Kirkwood");
ireneAddress.add("Lake avenue");
ireneAddress.add("Orange Drive");
ireneAddress.add("North Avenue");
ireneAddress.add("Maxwell Street");

List<String> ireneGotItem=new ArrayList<String>();

/*
 * FRANK
 */

List<String> frankItem= new ArrayList<String>();

List<String> frankAddress= new ArrayList<String>();

List<String> frankGotItem=new ArrayList<String>();
frankGotItem.add("Doorknob");

/*
 * HEATHER
 */
List<String> heatherItem= new ArrayList<String>();

List<String> heatherAddress= new ArrayList<String>();

List<String> heatherGotItem=new ArrayList<String>();
heatherGotItem.add("Orange Drive");

/*
 * JERRY
 */

List<String> jerryItem= new ArrayList<String>();

List<String> jerryAddress= new ArrayList<String>();

List<String> jerryGotItem=new ArrayList<String>();
jerryGotItem.add("HEATHER");

/*
 * GEORGE
 */
List<String> georgeItem= new ArrayList<String>();

List<String> georgeAddress= new ArrayList<String>();

List<String> georgeGotItem=new ArrayList<String>();

int i=0;
int j=0;
int k=0;
int l=0;
int m=0;
int n=0;
int o=0;
int p=0;
int q=0;
int r=0;


for(;!ireneItem.isEmpty();ireneItem.remove(ireneItem.get(i)))
{
	i=ireneItem.size()-1;
	for(;!ireneAddress.isEmpty();ireneAddress.remove(ireneAddress.get(j)))
	{
		j=ireneAddress.size()-1;
		
		frankItem.add("Candelabrum");
		frankItem.add("Banister");
		frankItem.add("Doorknob");
		frankItem.add("Elephant");
		frankItem.add("Amplifier");
		
		frankAddress.add("Kirkwood");
		frankAddress.add("Lake avenue");
		frankAddress.add("Orange Drive");
		frankAddress.add("North Avenue");
		frankAddress.add("Maxwell Street");
		
		frankItem.remove(ireneItem.get(i));
		frankItem.remove(frankGotItem.get(0));
		frankAddress.remove(ireneAddress.get(j));
		
		for(;!frankItem.isEmpty();frankItem.remove(frankItem.get(k)))
		{
			k=frankItem.size()-1;
			for(;!frankAddress.isEmpty();frankAddress.remove(frankAddress.get(l)))
			{
				l=frankAddress.size()-1;
				
				heatherItem.add("Candelabrum");
				heatherItem.add("Banister");
				heatherItem.add("Doorknob");
				heatherItem.add("Elephant");
				heatherItem.add("Amplifier");

				heatherAddress.add("Kirkwood");
				heatherAddress.add("Lake avenue");
				heatherAddress.add("Orange Drive");
				heatherAddress.add("North Avenue");
				heatherAddress.add("Maxwell Street");
				
				heatherItem.remove(ireneItem.get(i));
				heatherAddress.remove(ireneAddress.get(j));
				heatherItem.remove(frankItem.get(k));
				heatherAddress.remove(frankAddress.get(l));
				heatherItem.remove(heatherGotItem.get(0));
				
				for(;!heatherItem.isEmpty();heatherItem.remove(heatherItem.get(m)))
				{
					m=heatherItem.size()-1;
					for(;!heatherAddress.isEmpty();heatherAddress.remove(heatherAddress.get(n)))
					{
						n=heatherAddress.size()-1;
								
						jerryItem.add("Candelabrum");
						jerryItem.add("Banister");
						jerryItem.add("Doorknob");
						jerryItem.add("Elephant");
						jerryItem.add("Amplifier");

						jerryAddress.add("Kirkwood");
						jerryAddress.add("Lake avenue");
						jerryAddress.add("Orange Drive");
						jerryAddress.add("North Avenue");
						jerryAddress.add("Maxwell Street");
						
						jerryItem.remove(ireneItem.get(i));
						jerryAddress.remove(ireneAddress.get(j));
						jerryItem.remove(frankItem.get(k));
						jerryAddress.remove(frankAddress.get(l));
						jerryItem.remove(heatherItem.get(m));
						jerryAddress.remove(heatherAddress.get(n));
						jerryItem.remove(jerryGotItem.get(0));
						
						for(;!jerryItem.isEmpty();jerryItem.remove(jerryItem.get(o)))
						{
							o=jerryItem.size()-1;
							for(;!jerryAddress.isEmpty();jerryAddress.remove(jerryAddress.get(p)))
							{
								p=jerryAddress.size()-1;
								
								georgeItem.add("Candelabrum");
								georgeItem.add("Banister");
								georgeItem.add("Doorknob");
								georgeItem.add("Elephant");
								georgeItem.add("Amplifier");

								georgeAddress.add("Kirkwood");
								georgeAddress.add("Lake avenue");
								georgeAddress.add("Orange Drive");
								georgeAddress.add("North Avenue");
								georgeAddress.add("Maxwell Street");
								
								georgeItem.remove(ireneItem.get(i));
								georgeAddress.remove(ireneAddress.get(j));
								georgeItem.remove(frankItem.get(k));
								georgeAddress.remove(frankAddress.get(l));
								georgeItem.remove(heatherItem.get(m));
								georgeAddress.remove(heatherAddress.get(n));
								georgeItem.remove(jerryItem.get(o));
								georgeAddress.remove(jerryAddress.get(p));
								
								
								for(;!georgeItem.isEmpty();georgeItem.remove(georgeItem.get(q)))
								{
									q=georgeItem.size()-1;
									for(;!georgeAddress.isEmpty();georgeAddress.remove(georgeAddress.get(r)))
									{
										r=georgeAddress.size()-1;
										
		//-------------------------------------------------------------------------------------------------//								
										if("Candelabrum".equalsIgnoreCase(georgeItem.get(q)))
										{
											if(georgeGotItem.isEmpty())
											georgeGotItem.add("Banister");
										}
										else
										{
											georgeGotItem.remove("Banister");
										}
										
										if("Candelabrum".equalsIgnoreCase(jerryItem.get(o)))
										{
											if(jerryGotItem.isEmpty())
											jerryGotItem.add("Banister");
											else
											{
												if(!("Banister".equalsIgnoreCase(heatherItem.get(m))))
												{
													jerryGotItem.remove("Banister");
													continue;
												}
											}
										}
										else
										{
											jerryGotItem.remove("Banister");
										}
										
										if("Candelabrum".equalsIgnoreCase(heatherItem.get(m)))
										{
											if(heatherGotItem.isEmpty())
												heatherGotItem.add("Banister");
											else
											{
												//find the person from orange drive and put his ordred item as banister
												if("Orange drive".equalsIgnoreCase(georgeAddress.get(r))&& !"Banister".equalsIgnoreCase(georgeItem.get(q)))
												{
													heatherGotItem.remove("Banister");
													continue;
												}
												if("Orange drive".equalsIgnoreCase(jerryAddress.get(p))&& !"Banister".equalsIgnoreCase(jerryItem.get(p)))
												{
													heatherGotItem.remove("Banister");
													continue;
												}
												if("Orange drive".equalsIgnoreCase(frankAddress.get(l))&& !"Banister".equalsIgnoreCase(frankItem.get(k)))
												{
													heatherGotItem.remove("Banister");
													continue;
												}
												if("Orange drive".equalsIgnoreCase(ireneAddress.get(j))&& !"Banister".equalsIgnoreCase(ireneItem.get(i)))
												{
													heatherGotItem.remove("Banister");
													continue;
												}
											}
										}
										else
										{
											heatherGotItem.remove("Banister");
										}
										
										if("Candelabrum".equalsIgnoreCase(frankItem.get(k)))
										{
											continue;
										}
										
										if("Candelabrum".equalsIgnoreCase(ireneItem.get(i)))
										{
											if(ireneGotItem.isEmpty())
												ireneGotItem.add("Banister");
											else
											{
												if(person.contains(ireneGotItem.get(0)))
												{
													if("Frank".equalsIgnoreCase(ireneGotItem.get(0)) && !"Banister".equalsIgnoreCase(frankItem.get(k)))
													{
														continue;
													}
													if("George".equalsIgnoreCase(ireneGotItem.get(0)) && !"Banister".equalsIgnoreCase(georgeItem.get(q)))
													{
														continue;
													}
													if("Heather".equalsIgnoreCase(ireneGotItem.get(0)) && !"Banister".equalsIgnoreCase(heatherItem.get(m)))
													{
														continue;
													}
													if("Jerry".equalsIgnoreCase(ireneGotItem.get(0)) && !"Banister".equalsIgnoreCase(jerryItem.get(o)))
													{
														continue;
													}
												}
												if(item.contains(ireneGotItem.get(0)))
												{
													if(!"Banister".equalsIgnoreCase(ireneGotItem.get(0)))
														continue;
												}
												if(address.contains(ireneGotItem.get(0)))
												{
													if(georgeAddress.get(r).equalsIgnoreCase(ireneGotItem.get(0)) && !"Banister".equalsIgnoreCase(georgeItem.get(q)))
														continue;
													if(frankAddress.get(l).equalsIgnoreCase(ireneGotItem.get(0)) && !"Banister".equalsIgnoreCase(frankItem.get(k)))
														continue;
													if(heatherAddress.get(n).equalsIgnoreCase(ireneGotItem.get(0)) && !"Banister".equalsIgnoreCase(heatherItem.get(m)))
														continue;
													if(jerryAddress.get(p).equalsIgnoreCase(ireneGotItem.get(0)) && !"Banister".equalsIgnoreCase(jerryItem.get(o)))
														continue;
												}
											}
										}
										else
										{
											ireneGotItem.remove("Banister");
										}
		//-----------------------------------------------------------------------------------------------------//								
										if("Banister".equalsIgnoreCase(georgeItem.get(q)))
										{
												if(georgeGotItem.isEmpty())
												georgeGotItem.add(ireneItem.get(i));
												else
												{
													if(person.contains(georgeItem.get(q)))
													{
														if(!"Irene".equalsIgnoreCase(georgeItem.get(q)))
														{
															georgeGotItem.remove(ireneItem.get(i));
															continue;
														}
													}
													if(item.contains(georgeItem.get(q)))
													{
														if(!ireneItem.get(i).equalsIgnoreCase(georgeItem.get(q)))
														{
															georgeGotItem.remove(ireneItem.get(i));
															continue;
														}
													}
													if(address.contains(georgeItem.get(q)))
													{
														if(!ireneAddress.get(j).equalsIgnoreCase(georgeItem.get(q)))
														{
															georgeGotItem.remove(ireneItem.get(i));
															continue;
														}
													}
												}
											
										}
										else
										{
											georgeGotItem.remove(ireneItem.get(i));
										}
										
										if("Banister".equalsIgnoreCase(jerryItem.get(o)))
										{
											continue;
										}
										
										if("Banister".equalsIgnoreCase(heatherItem.get(m)))
										{
											if(!"Orange drive".equalsIgnoreCase(ireneAddress.get(j)))
												continue;
										}
										
										if("Banister".equalsIgnoreCase(frankItem.get(k)))
										{
											if(!"Doorknob".equalsIgnoreCase(ireneItem.get(i)))
												continue;
										}
										
										if("Banister".equalsIgnoreCase(ireneItem.get(i)))
										{
											continue;
										}
		//---------------------------------------------------------------------------------------------------------//								
										
										if("Kirkwood".equalsIgnoreCase(georgeAddress.get(r)))
										{
											continue;
										}
										
										if("Kirkwood".equalsIgnoreCase(jerryAddress.get(p)))
										{
											continue;
										}
										
										if("Kirkwood".equalsIgnoreCase(heatherAddress.get(n)))
										{
											if(!"Orange drive".equalsIgnoreCase(georgeAddress.get(r)))
												continue;
										}
										
										if("Kirkwood".equalsIgnoreCase(frankAddress.get(l)))
										{
											if(!"Doorknob".equalsIgnoreCase(georgeItem.get(q)))
												continue;
										}
										
										if("Kirkwood".equalsIgnoreCase(ireneAddress.get(j)))
										{
											if(ireneGotItem.isEmpty())
											{
											ireneGotItem.add(georgeItem.get(q));
											}
											else
											{
												if(person.contains(ireneGotItem.get(0)))
												{
													ireneGotItem.remove(georgeItem.get(q));
													continue;
												}
												if(address.contains(ireneGotItem.get(0)))
												{
													if(!georgeAddress.get(r).equalsIgnoreCase(ireneGotItem.get(0)))
													{
														ireneGotItem.remove(georgeItem.get(q));
														continue;
													}
												}
												if(item.contains(ireneGotItem.get(0)))
												{
													if(!georgeItem.get(q).equalsIgnoreCase(ireneGotItem.get(0)))
													{
														ireneGotItem.remove(georgeItem.get(q));
														continue;
													}
												}
												
											}
												
										}
										else
										{
											ireneGotItem.remove(georgeItem.get(q));
										}
										
		//--------------------------------------------------------------------------------------------------------//								
										
										if("Lake avenue".equalsIgnoreCase(georgeAddress.get(r)))
										{
											if(georgeGotItem.isEmpty())
											georgeGotItem.add("Kirkwood");
											else
											{
												if(address.contains(georgeGotItem.get(0)) && !"Kirkwood".equalsIgnoreCase(georgeGotItem.get(0)))
													continue;
												if(person.contains(georgeGotItem.get(0)))
												{
													if("Irene".equalsIgnoreCase(georgeGotItem.get(0)))
													{
														if(!"Kirkwood".equalsIgnoreCase(ireneAddress.get(j)))
															continue;
													}
													if("George".equalsIgnoreCase(georgeGotItem.get(0)))
													{
														continue;
													}
													if("Jerry".equalsIgnoreCase(georgeGotItem.get(0)))
													{
														if(!"Kirkwood".equalsIgnoreCase(jerryAddress.get(p)))
															continue;
													}
													if("Frank".equalsIgnoreCase(georgeGotItem.get(0)))
													{
														if(!"Kirkwood".equalsIgnoreCase(frankAddress.get(l)))
															continue;
													}
													if("Heather".equalsIgnoreCase(georgeGotItem.get(0)))
													{
														if(!"Kirkwood".equalsIgnoreCase(heatherAddress.get(n)))
															continue;
													}
												}
												
												if(item.contains(georgeGotItem.get(0)))
												{
													if(ireneItem.get(i).equalsIgnoreCase(georgeGotItem.get(0)))
													{
														if(!"Kirkwood".equalsIgnoreCase(ireneAddress.get(j)))
															continue;
													}
												/*	if(georgeItem.get(q).equalsIgnoreCase(georgeGotItem.get(0)))
													{
														continue;
													}*/
													if(jerryItem.get(o).equalsIgnoreCase(georgeGotItem.get(0)))
													{
														if(!"Kirkwood".equalsIgnoreCase(jerryAddress.get(p)))
															continue;
													}
													if(frankItem.get(k).equalsIgnoreCase(georgeGotItem.get(0)))
													{
														if(!"Kirkwood".equalsIgnoreCase(frankAddress.get(l)))
															continue;
													}
													if(heatherItem.get(m).equalsIgnoreCase(georgeGotItem.get(0)))
													{
														if(!"Kirkwood".equalsIgnoreCase(heatherAddress.get(n)))
															continue;
													}
												}
											}
										}
										else
										{
											georgeGotItem.remove("Kirkwood");
										}
										
										if("Lake avenue".equalsIgnoreCase(jerryAddress.get(p)))
										{
											if(!"Kirkwood".equalsIgnoreCase(heatherAddress.get(n)))
												continue;
										}
										
										if("Lake avenue".equalsIgnoreCase(heatherAddress.get(n)))
										{
											continue;
										}
										
										if("Lake avenue".equalsIgnoreCase(frankAddress.get(l)))
										{
											if("Kirkwood".equalsIgnoreCase(ireneAddress.get(j)) && !"Doorknob".equalsIgnoreCase(ireneItem.get(i)))
												continue;
											if("Kirkwood".equalsIgnoreCase(georgeAddress.get(r)) && !"Doorknob".equalsIgnoreCase(georgeItem.get(q)))
												continue;
											if("Kirkwood".equalsIgnoreCase(jerryAddress.get(p)) && !"Doorknob".equalsIgnoreCase(jerryItem.get(o)))
												continue;
											if("Kirkwood".equalsIgnoreCase(heatherAddress.get(n)) && !"Doorknob".equalsIgnoreCase(heatherItem.get(m)))
												continue;
										}
										
										if("Lake avenue".equalsIgnoreCase(ireneAddress.get(j)))
										{
											if(ireneGotItem.isEmpty())
												ireneGotItem.add("Kirkwood");
												else
												{
													if(address.contains(ireneGotItem.get(0)) && !"Kirkwood".equalsIgnoreCase(ireneGotItem.get(0)))
														continue;
													if(person.contains(ireneGotItem.get(0)))
													{
														if("George".equalsIgnoreCase(ireneGotItem.get(0)))
														{
															if(!"Kirkwood".equalsIgnoreCase(georgeAddress.get(r)))
																continue;
														}
														if("Irene".equalsIgnoreCase(georgeGotItem.get(0)))
														{
															continue;
														}
														if("Jerry".equalsIgnoreCase(ireneGotItem.get(0)))
														{
															if(!"Kirkwood".equalsIgnoreCase(jerryAddress.get(p)))
																continue;
														}
														if("Frank".equalsIgnoreCase(ireneGotItem.get(0)))
														{
															if(!"Kirkwood".equalsIgnoreCase(frankAddress.get(l)))
																continue;
														}
														if("Heather".equalsIgnoreCase(ireneGotItem.get(0)))
														{
															if(!"Kirkwood".equalsIgnoreCase(heatherAddress.get(n)))
																continue;
														}
													}
													
													if(item.contains(ireneGotItem.get(0)))
													{
														if(georgeItem.get(q).equalsIgnoreCase(ireneGotItem.get(0)))
														{
															if(!"Kirkwood".equalsIgnoreCase(ireneAddress.get(j)))
																continue;
														}
													/*	if(ireneItem.get(i).equalsIgnoreCase(ireneGotItem.get(0)))
														{
															continue;
														}*/
														if(jerryItem.get(o).equalsIgnoreCase(ireneGotItem.get(0)))
														{
															if(!"Kirkwood".equalsIgnoreCase(jerryAddress.get(p)))
																continue;
														}
														if(frankItem.get(k).equalsIgnoreCase(ireneGotItem.get(0)))
														{
															if(!"Kirkwood".equalsIgnoreCase(frankAddress.get(l)))
																continue;
														}
														if(heatherItem.get(m).equalsIgnoreCase(ireneGotItem.get(0)))
														{
															if(!"Kirkwood".equalsIgnoreCase(heatherAddress.get(n)))
																continue;
														}
													}
												}
										}
										else
										{
											ireneGotItem.remove("Kirkwood");
										}
										
		//--------------------------------------------------------------------------------------------------------//								
										
										if("North Avenue".equalsIgnoreCase(georgeAddress.get(r)))
										{
											if(georgeGotItem.isEmpty())
												georgeGotItem.add("Elephant");
											else
											{
												if(person.contains(georgeGotItem.get(0)))
												{
													if("Irene".equalsIgnoreCase(georgeGotItem.get(0)) && !"Elephant".equalsIgnoreCase(ireneItem.get(i)))
														continue;
													if("Frank".equalsIgnoreCase(georgeGotItem.get(0)) && !"Elephant".equalsIgnoreCase(frankItem.get(k)))
														continue;
													if("Heather".equalsIgnoreCase(georgeGotItem.get(0)) && !"Elephant".equalsIgnoreCase(heatherItem.get(m)))
														continue;
													if("Jerry".equalsIgnoreCase(georgeGotItem.get(0)) && !"Elephant".equalsIgnoreCase(jerryItem.get(o)))
														continue;
												}
												if(address.contains(georgeGotItem.get(0)))
												{
													if(ireneAddress.get(j).equalsIgnoreCase(georgeGotItem.get(0)) && !"Elephant".equalsIgnoreCase(ireneItem.get(i)))
														continue;
													if(frankAddress.get(l).equalsIgnoreCase(georgeGotItem.get(0)) && !"Elephant".equalsIgnoreCase(frankItem.get(k)))
														continue;
													if(heatherAddress.get(n).equalsIgnoreCase(georgeGotItem.get(0)) && !"Elephant".equalsIgnoreCase(heatherItem.get(m)))
														continue;
													if(jerryAddress.get(p).equalsIgnoreCase(georgeGotItem.get(0)) && !"Elephant".equalsIgnoreCase(jerryItem.get(o)))
														continue;
												}
												if(!item.contains(georgeGotItem.get(0).equalsIgnoreCase("Elephant")))
													continue;
											}
										}
										else
										{
											georgeGotItem.remove("Elephant");
										}
										
										if("North Avenue".equalsIgnoreCase(jerryAddress.get(p)))
										{
											if(!"Elepahnt".equalsIgnoreCase(heatherItem.get(m)))
													continue;
										}
										
										if("North Avenue".equalsIgnoreCase(heatherAddress.get(n)))
										{
											if(ireneAddress.get(j).equalsIgnoreCase("Orange Drive") && !"Elephant".equalsIgnoreCase(ireneItem.get(i)))
												continue;
											if(frankAddress.get(l).equalsIgnoreCase("Orange Drive") && !"Elephant".equalsIgnoreCase(frankItem.get(k)))
												continue;
											if(heatherAddress.get(n).equalsIgnoreCase("Orange Drive") && !"Elephant".equalsIgnoreCase(heatherItem.get(m)))
												continue;
											if(jerryAddress.get(p).equalsIgnoreCase("Orange Drive") && !"Elephant".equalsIgnoreCase(jerryItem.get(o)))
												continue;
										}
										
										if("North Avenue".equalsIgnoreCase(frankAddress.get(l)))
										{
											continue;
										}
										
										if("North Avenue".equalsIgnoreCase(ireneAddress.get(j)))
										{
											if(ireneGotItem.isEmpty())
												ireneGotItem.add("Elephant");
											else
											{
												if(person.contains(ireneGotItem.get(0)))
												{
													if("George".equalsIgnoreCase(ireneGotItem.get(0)) && !"Elephant".equalsIgnoreCase(georgeItem.get(q)))
														continue;
													if("Frank".equalsIgnoreCase(ireneGotItem.get(0)) && !"Elephant".equalsIgnoreCase(frankItem.get(k)))
														continue;
													if("Heather".equalsIgnoreCase(ireneGotItem.get(0)) && !"Elephant".equalsIgnoreCase(heatherItem.get(m)))
														continue;
													if("Jerry".equalsIgnoreCase(ireneGotItem.get(0)) && !"Elephant".equalsIgnoreCase(jerryItem.get(o)))
														continue;
												}
												if(address.contains(ireneGotItem.get(0)))
												{
													if(georgeAddress.get(j).equalsIgnoreCase(ireneGotItem.get(0)) && !"Elephant".equalsIgnoreCase(georgeItem.get(q)))
														continue;
													if(frankAddress.get(l).equalsIgnoreCase(ireneGotItem.get(0)) && !"Elephant".equalsIgnoreCase(frankItem.get(k)))
														continue;
													if(heatherAddress.get(n).equalsIgnoreCase(ireneGotItem.get(0)) && !"Elephant".equalsIgnoreCase(heatherItem.get(m)))
														continue;
													if(jerryAddress.get(p).equalsIgnoreCase(ireneGotItem.get(0)) && !"Elephant".equalsIgnoreCase(jerryItem.get(o)))
														continue;
												}
												if(!item.contains(ireneGotItem.get(0).equalsIgnoreCase("Elephant")))
													continue;
											}
										}
										else
										{
											ireneGotItem.remove("Elephant");
										}
										
		//----------------------------------------------------------------------------------------------------------//	
										if("Elephant".equalsIgnoreCase(georgeItem.get(q)))
										{
											if(georgeGotItem.isEmpty())
											georgeGotItem.add("Maxwell street");
											else
											{
												if(person.contains(georgeGotItem.get(0)))
												{
													if("Irene".equalsIgnoreCase(georgeGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(ireneAddress.get(j)))
													{
														georgeGotItem.remove("Maxwell street");
														continue;
													}
													if("Frank".equalsIgnoreCase(georgeGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(frankAddress.get(l)))
													{
														georgeGotItem.remove("Maxwell street");
														continue;
													}
													if("Heather".equalsIgnoreCase(georgeGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(heatherAddress.get(n)))
													{
														georgeGotItem.remove("Maxwell street");
														continue;
													}
													if("Jerry".equalsIgnoreCase(georgeGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(jerryAddress.get(p)))
													{
														georgeGotItem.remove("Maxwell street");
														continue;
													}
												}
												
												if(item.contains(georgeGotItem.get(0)))
												{
													if(ireneItem.get(i).equalsIgnoreCase(georgeGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(ireneAddress.get(j)))
													{
														georgeGotItem.remove("Maxwell street");
														continue;
													}
													if(frankItem.get(k).equalsIgnoreCase(georgeGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(frankAddress.get(l)))
													{
														georgeGotItem.remove("Maxwell street");
														continue;
													}
													if(heatherItem.get(m).equalsIgnoreCase(georgeGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(heatherAddress.get(n)))
													{
														georgeGotItem.remove("Maxwell street");
														continue;
													}
													if(jerryItem.get(o).equalsIgnoreCase(georgeGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(jerryAddress.get(p)))
													{
														georgeGotItem.remove("Maxwell street");
														continue;
													}
												}
												
												if(address.contains(georgeGotItem.get(0)))
												{
													continue;
												}
											}
											
										}
										else
										{
											georgeGotItem.remove("Maxwell street");
										}
										
										if("Elephant".equalsIgnoreCase(jerryItem.get(o)))
										{
											if(!"Maxwell street".equalsIgnoreCase(heatherAddress.get(n)))
												continue;
										}
										
										if("Elephant".equalsIgnoreCase(heatherItem.get(m)))
										{
											continue;
										}
										
										if("Elephant".equalsIgnoreCase(frankItem.get(k)))
										{
											if("Doorknob".equalsIgnoreCase(ireneItem.get(i)) && !"Maxwell Street".equalsIgnoreCase(ireneAddress.get(j)))
													continue;
											if("Doorknob".equalsIgnoreCase(georgeItem.get(q)) && !"Maxwell Street".equalsIgnoreCase(georgeAddress.get(r)))
												continue;
											if("Doorknob".equalsIgnoreCase(heatherItem.get(m)) && !"Maxwell Street".equalsIgnoreCase(heatherAddress.get(n)))
												continue;
											if("Doorknob".equalsIgnoreCase(jerryItem.get(o)) && !"Maxwell Street".equalsIgnoreCase(jerryAddress.get(p)))
												continue;
										}
										
										if("Elephant".equalsIgnoreCase(ireneItem.get(i)))
										{
											if(ireneGotItem.isEmpty())
												ireneGotItem.add("Maxwell street");
												else
												{
													if(person.contains(ireneGotItem.get(0)))
													{
														if("George".equalsIgnoreCase(ireneGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(georgeAddress.get(r)))
														{
															ireneGotItem.remove("Maxwell street");
															continue;
														}
														if("Frank".equalsIgnoreCase(ireneGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(frankAddress.get(l)))
														{
															ireneGotItem.remove("Maxwell street");
															continue;
														}
														if("Heather".equalsIgnoreCase(ireneGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(heatherAddress.get(n)))
														{
															ireneGotItem.remove("Maxwell street");
															continue;
														}
														if("Jerry".equalsIgnoreCase(ireneGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(jerryAddress.get(p)))
														{
															ireneGotItem.remove("Maxwell street");
															continue;
														}
													}
													
													if(item.contains(ireneGotItem.get(0)))
													{
														if(georgeItem.get(q).equalsIgnoreCase(ireneGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(georgeAddress.get(r)))
														{
															ireneGotItem.remove("Maxwell street");
															continue;
														}
														if(frankItem.get(k).equalsIgnoreCase(ireneGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(frankAddress.get(l)))
														{
															ireneGotItem.remove("Maxwell street");
															continue;
														}
														if(heatherItem.get(m).equalsIgnoreCase(ireneGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(heatherAddress.get(n)))
														{
															ireneGotItem.remove("Maxwell street");
															continue;
														}
														if(jerryItem.get(o).equalsIgnoreCase(ireneGotItem.get(0)) && !"Maxwell Street".equalsIgnoreCase(jerryAddress.get(p)))
														{
															ireneGotItem.remove("Maxwell street");
															continue;
														}
													}
													
													if(address.contains(georgeGotItem.get(0)))
													{
														continue;
													}
												}
										}
										else
										{
											ireneGotItem.remove("Maxwell street");
										}
		//---------------------------------------------------------------------------------------------------------//
										
										if("Maxwell Street".equalsIgnoreCase(georgeAddress.get(r)))
										{
											if(georgeGotItem.isEmpty())
												georgeGotItem.add("Amplifier");
											else
											{
												if(person.contains(georgeGotItem.get(0)))
												{
													if("Irene".equalsIgnoreCase(georgeGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(ireneItem.get(i)))
														continue;
													if("Frank".equalsIgnoreCase(georgeGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(frankItem.get(k)))
														continue;
													if("Heather".equalsIgnoreCase(georgeGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(heatherItem.get(m)))
														continue;
													if("Jerry".equalsIgnoreCase(georgeGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(jerryItem.get(o)))
														continue;
												}
												if(address.contains(georgeGotItem.get(0)))
												{
													if(ireneAddress.get(j).equalsIgnoreCase(georgeGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(ireneItem.get(i)))
														continue;
													if(frankAddress.get(l).equalsIgnoreCase(georgeGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(frankItem.get(k)))
														continue;
													if(heatherAddress.get(n).equalsIgnoreCase(georgeGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(heatherItem.get(m)))
														continue;
													if(jerryAddress.get(p).equalsIgnoreCase(georgeGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(jerryItem.get(o)))
														continue;
												}
												if(!item.contains(georgeGotItem.get(0).equalsIgnoreCase("Amplifier")))
													continue;
											}
										}
										else
										{
											georgeGotItem.remove("Amplifier");
										}
										
										if("Maxwell Street".equalsIgnoreCase(jerryAddress.get(p)))
										{
											if(!"Amplifier".equalsIgnoreCase(heatherItem.get(m)))
													continue;
										}
										
										if("Maxwell Street".equalsIgnoreCase(heatherAddress.get(n)))
										{
											if(ireneAddress.get(j).equalsIgnoreCase("Orange Drive") && !"Amplifier".equalsIgnoreCase(ireneItem.get(i)))
												continue;
											if(frankAddress.get(l).equalsIgnoreCase("Orange Drive") && !"Amplifier".equalsIgnoreCase(frankItem.get(k)))
												continue;
											if(heatherAddress.get(n).equalsIgnoreCase("Orange Drive") && !"Amplifier".equalsIgnoreCase(heatherItem.get(m)))
												continue;
											if(jerryAddress.get(p).equalsIgnoreCase("Orange Drive") && !"Amplifier".equalsIgnoreCase(jerryItem.get(o)))
												continue;
										}
										
										if("Maxwell Street".equalsIgnoreCase(frankAddress.get(l)))
										{
											continue;
										}
										
										if("Maxwell Street".equalsIgnoreCase(ireneAddress.get(j)))
										{
											if(ireneGotItem.isEmpty())
												ireneGotItem.add("Amplifier");
											else
											{
												if(person.contains(ireneGotItem.get(0)))
												{
													if("George".equalsIgnoreCase(ireneGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(georgeItem.get(q)))
														continue;
													if("Frank".equalsIgnoreCase(ireneGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(frankItem.get(k)))
														continue;
													if("Heather".equalsIgnoreCase(ireneGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(heatherItem.get(m)))
														continue;
													if("Jerry".equalsIgnoreCase(ireneGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(jerryItem.get(o)))
														continue;
												}
												if(address.contains(ireneGotItem.get(0)))
												{
													if(georgeAddress.get(j).equalsIgnoreCase(ireneGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(georgeItem.get(q)))
														continue;
													if(frankAddress.get(l).equalsIgnoreCase(ireneGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(frankItem.get(k)))
														continue;
													if(heatherAddress.get(n).equalsIgnoreCase(ireneGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(heatherItem.get(m)))
														continue;
													if(jerryAddress.get(p).equalsIgnoreCase(ireneGotItem.get(0)) && !"Amplifier".equalsIgnoreCase(jerryItem.get(o)))
														continue;
												}
												if(!item.contains(ireneGotItem.get(0).equalsIgnoreCase("Amplifier")))
													continue;
											}
										}
										else
										{
											ireneGotItem.remove("Amplifier");
										}
										
		//-----------------------------------------------------------------------------------------------------------------//								
										
										/*if(!georgeGotItem.isEmpty())
										{
											if(georgeItem.get(q).equalsIgnoreCase(georgeGotItem.get(0)))
												//georgeItem.remove(georgeGotItem.get(0));
												continue;
											if(georgeAddress.get(r).equalsIgnoreCase((georgeGotItem.get(0))))
												//georgeAddress.remove(georgeGotItem.get(0));
												continue;
											if(person.contains(georgeGotItem.get(0)))
											{
												if("Irene".equalsIgnoreCase(georgeGotItem.get(0)))
												{
													if(georgeItem.get(q).equalsIgnoreCase(ireneItem.get(i)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(georgeAddress.get(r).equalsIgnoreCase((ireneAddress.get(j))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
													
													
												//georgeItem.remove(ireneItem.get(i));
												//georgeAddress.remove(ireneAddress.get(j));
												}
												
												if("Jerry".equalsIgnoreCase(georgeGotItem.get(0)))
												{
													if(georgeItem.get(q).equalsIgnoreCase(jerryItem.get(o)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(georgeAddress.get(r).equalsIgnoreCase((jerryAddress.get(p))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
												//georgeItem.remove(jerryItem.get(i));
												//georgeAddress.remove(jerryAddress.get(j));
												}
												
												if("Frank".equalsIgnoreCase(georgeGotItem.get(0)))
												{
													if(georgeItem.get(q).equalsIgnoreCase(frankItem.get(k)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(georgeAddress.get(r).equalsIgnoreCase((frankAddress.get(l))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
												//georgeItem.remove(frankItem.get(i));
												//georgeAddress.remove(frankAddress.get(j));
												}
												
												if("Heather".equalsIgnoreCase(georgeGotItem.get(0)))
												{
													
													if(georgeItem.get(q).equalsIgnoreCase(heatherItem.get(m)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(georgeAddress.get(r).equalsIgnoreCase((heatherAddress.get(n))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
												//georgeItem.remove(heatherItem.get(i));
												//georgeAddress.remove(heatherAddress.get(j));
												}
											}
										}
										
										if(!jerryGotItem.isEmpty())
										{
											if(jerryItem.get(o).equalsIgnoreCase(jerryGotItem.get(0)))
												//georgeItem.remove(georgeGotItem.get(0));
												continue;
											if(jerryAddress.get(p).equalsIgnoreCase((jerryGotItem.get(0))))
												//georgeAddress.remove(georgeGotItem.get(0));
												continue;
											if(person.contains(jerryGotItem.get(0)))
											{
												if("Irene".equalsIgnoreCase(jerryGotItem.get(0)))
												{
													if(jerryItem.get(o).equalsIgnoreCase(ireneItem.get(i)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(jerryAddress.get(p).equalsIgnoreCase((ireneAddress.get(j))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
													
													
												//georgeItem.remove(ireneItem.get(i));
												//georgeAddress.remove(ireneAddress.get(j));
												}
												
												if("George".equalsIgnoreCase(jerryGotItem.get(0)))
												{
													if(jerryItem.get(o).equalsIgnoreCase(georgeItem.get(q)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(jerryAddress.get(p).equalsIgnoreCase((georgeAddress.get(r))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
												//georgeItem.remove(jerryItem.get(i));
												//georgeAddress.remove(jerryAddress.get(j));
												}
												
												if("Frank".equalsIgnoreCase(jerryGotItem.get(0)))
												{
													if(jerryItem.get(o).equalsIgnoreCase(frankItem.get(k)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(jerryAddress.get(p).equalsIgnoreCase((frankAddress.get(l))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
												//georgeItem.remove(frankItem.get(i));
												//georgeAddress.remove(frankAddress.get(j));
												}
												
												if("Heather".equalsIgnoreCase(jerryGotItem.get(0)))
												{
													
													if(jerryItem.get(o).equalsIgnoreCase(heatherItem.get(m)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(jerryAddress.get(p).equalsIgnoreCase((heatherAddress.get(n))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
												//georgeItem.remove(heatherItem.get(i));
												//georgeAddress.remove(heatherAddress.get(j));
												}
											}
										}
										
										
										if(!heatherGotItem.isEmpty())
										{
											if(heatherItem.get(m).equalsIgnoreCase(heatherGotItem.get(0)))
												//georgeItem.remove(georgeGotItem.get(0));
												continue;
											if(heatherAddress.get(n).equalsIgnoreCase((heatherGotItem.get(0))))
												//georgeAddress.remove(georgeGotItem.get(0));
												continue;
											if(person.contains(heatherGotItem.get(0)))
											{
												if("Irene".equalsIgnoreCase(heatherGotItem.get(0)))
												{
													if(heatherItem.get(m).equalsIgnoreCase(ireneItem.get(i)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(heatherAddress.get(n).equalsIgnoreCase((ireneAddress.get(j))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
													
													
												//georgeItem.remove(ireneItem.get(i));
												//georgeAddress.remove(ireneAddress.get(j));
												}
												
												if("George".equalsIgnoreCase(heatherGotItem.get(0)))
												{
													if(heatherItem.get(m).equalsIgnoreCase(georgeItem.get(q)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(heatherAddress.get(n).equalsIgnoreCase((georgeAddress.get(r))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
												//georgeItem.remove(jerryItem.get(i));
												//georgeAddress.remove(jerryAddress.get(j));
												}
												
												if("Frank".equalsIgnoreCase(heatherGotItem.get(0)))
												{
													if(heatherItem.get(m).equalsIgnoreCase(frankItem.get(k)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(heatherAddress.get(n).equalsIgnoreCase((frankAddress.get(l))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
												//georgeItem.remove(frankItem.get(i));
												//georgeAddress.remove(frankAddress.get(j));
												}
												
												if("Jerry".equalsIgnoreCase(heatherGotItem.get(0)))
												{
													
													if(heatherItem.get(m).equalsIgnoreCase(jerryItem.get(o)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(heatherAddress.get(n).equalsIgnoreCase((jerryAddress.get(p))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
												//georgeItem.remove(heatherItem.get(i));
												//georgeAddress.remove(heatherAddress.get(j));
												}
											}
										}
										
										
										
										if(!frankGotItem.isEmpty())
										{
											if(frankItem.get(k).equalsIgnoreCase(frankGotItem.get(0)))
												//georgeItem.remove(georgeGotItem.get(0));
												continue;
											if(frankAddress.get(l).equalsIgnoreCase((frankGotItem.get(0))))
												//georgeAddress.remove(georgeGotItem.get(0));
												continue;
											if(person.contains(frankGotItem.get(0)))
											{
												if("Irene".equalsIgnoreCase(frankGotItem.get(0)))
												{
													if(frankItem.get(k).equalsIgnoreCase(ireneItem.get(i)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(frankAddress.get(l).equalsIgnoreCase((ireneAddress.get(j))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
													
													
												//georgeItem.remove(ireneItem.get(i));
												//georgeAddress.remove(ireneAddress.get(j));
												}
												
												if("George".equalsIgnoreCase(frankGotItem.get(0)))
												{
													if(frankItem.get(k).equalsIgnoreCase(georgeItem.get(q)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(frankAddress.get(l).equalsIgnoreCase((georgeAddress.get(r))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
												//georgeItem.remove(jerryItem.get(i));
												//georgeAddress.remove(jerryAddress.get(j));
												}
												
												if("Heather".equalsIgnoreCase(frankGotItem.get(0)))
												{
													if(frankItem.get(k).equalsIgnoreCase(heatherItem.get(m)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(frankAddress.get(l).equalsIgnoreCase((heatherAddress.get(n))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
												//georgeItem.remove(frankItem.get(i));
												//georgeAddress.remove(frankAddress.get(j));
												}
												
												if("Jerry".equalsIgnoreCase(frankGotItem.get(0)))
												{
													
													if(frankItem.get(k).equalsIgnoreCase(jerryItem.get(o)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(frankAddress.get(l).equalsIgnoreCase((jerryAddress.get(p))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
												//georgeItem.remove(heatherItem.get(i));
												//georgeAddress.remove(heatherAddress.get(j));
												}
											}
										}
										
										
										
										if(!ireneGotItem.isEmpty())
										{
											if(ireneItem.get(i).equalsIgnoreCase(ireneGotItem.get(0)))
												//georgeItem.remove(georgeGotItem.get(0));
												continue;
											if(ireneAddress.get(j).equalsIgnoreCase((ireneGotItem.get(0))))
												//georgeAddress.remove(georgeGotItem.get(0));
												continue;
											if(person.contains(ireneGotItem.get(0)))
											{
												if("Frank".equalsIgnoreCase(ireneGotItem.get(0)))
												{
													if(ireneItem.get(i).equalsIgnoreCase(frankItem.get(k)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(ireneAddress.get(j).equalsIgnoreCase((frankAddress.get(l))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
													
													
												//georgeItem.remove(ireneItem.get(i));
												//georgeAddress.remove(ireneAddress.get(j));
												}
												
												if("George".equalsIgnoreCase(ireneGotItem.get(0)))
												{
													if(ireneItem.get(i).equalsIgnoreCase(georgeItem.get(q)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(ireneAddress.get(j).equalsIgnoreCase((georgeAddress.get(r))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
												//georgeItem.remove(jerryItem.get(i));
												//georgeAddress.remove(jerryAddress.get(j));
												}
												
												if("Heather".equalsIgnoreCase(ireneGotItem.get(0)))
												{
													if(ireneItem.get(i).equalsIgnoreCase(heatherItem.get(m)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(ireneAddress.get(j).equalsIgnoreCase((heatherAddress.get(n))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
												//georgeItem.remove(frankItem.get(i));
												//georgeAddress.remove(frankAddress.get(j));
												}
												
												if("Jerry".equalsIgnoreCase(ireneGotItem.get(0)))
												{
													
													if(ireneItem.get(i).equalsIgnoreCase(jerryItem.get(o)))
														//georgeItem.remove(georgeGotItem.get(0));
														continue;
													if(ireneAddress.get(j).equalsIgnoreCase((jerryAddress.get(p))))
														//georgeAddress.remove(georgeGotItem.get(0));
														continue;
												//georgeItem.remove(heatherItem.get(i));
												//georgeAddress.remove(heatherAddress.get(j));
												}
											}
										}*/
										
										
										System.out.println("success");
										System.out.println(ireneItem+"::::"+frankItem+"::::"+georgeItem+":::::"+heatherItem+":::::"+jerryItem+":::");
										
									}
								}
							}
						}
					
					}
				}
			}
			
		}
	}
}
//System.out.println(ireneItem+"::::"+frankItem+"::::"+georgeItem+":::::"+heatherItem+":::::"+jerryItem+":::");

}
}
