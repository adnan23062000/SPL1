var xmlhttp
var qxml, numberOfQuestions, choices, currentQuestion, questionType, dArrays, vnames,decimal
var qnum=-1
decimal=0
var feedbackA1
var tryNumber=0;
var noFeedback = "Please answer all questions even if you have to guess. Then use the simulation/demonstration to help. Explanations will not be shown until your second time through questions. Check your answer for all questions and then go back to the first question to see the explanations."
function getQuestion(str)
	
{

	if (str.length==0) {
		try{
		  feedback01=document.getElementById("feedback")
		  if (feedback01) {
			  feedback01.innerHTML="";
			  feedback01.style.visibility='hidden';
		  }
		  qb= document.getElementById("question_buttons")
		  if(qb) {
			  
			 qb.innerHTML="";
			 qb.style.visibility='hidden';
			 
			 
		  }
		  disp = document.getElementById("display")
		  if(disp) {
			  disp.style.visibility='hidden';
		  		disp.innerHTML=""
		  }
		  var fb= document.getElementById("display")
		   if(fb){
		   	fb.innerHTML=""
			if(fb) fb.style.visibility='hidden';
		   }
		}
		
		catch(error) {
			
			
		}
		  
	}
	
	
	else {
		thisLoc =new String(this.location)
		locArray = thisLoc.split("/")
		str=locArray[locArray.length-2] + "/" + str
	
		xmlhttp=GetXmlHttpObject();
		
	
  
  
	
		if (xmlhttp==null)
		  {
		  alert ("Your browser does not support XMLHTTP!");
		  return;
		  }
		var url="../getFile.php";
		url=url+"?q="+str;
		url=url+"&sid="+Math.random();
		xmlhttp.onreadystatechange=stateChanged;
		xmlhttp.open("GET",url,true);
		xmlhttp.send(null);
	}

}

function stateChanged() {
  if (xmlhttp.readyState==4)
	{
	  qxml =xmlhttp.responseXML
	  numberOfQuestions = qxml.getElementsByTagName("question").length
	  if (qxml.getElementsByTagName("simulation").length  == 0)
		  feedbackA1 = true
	  else
		  feedbackA1 = false
		  
	  next()
	  
	}
}
function next() {
	tryNumber=0
	qnum++
	if(qnum > 0)
		document.getElementById("b1").disabled=false
		
	showQuestion()
	if(qnum + 1 == numberOfQuestions){
		document.getElementById("b2").disabled=true
	
		if (!feedbackA1) {
			feedbackA1 = true
			qnum=-1
			document.getElementById("b2").disabled=false
		}
		
		
		
	}
	
}

function firstQuestion() {
	qnum=1
	previous()
	
	
}

function previous() {
	qnum--
	showQuestion()
	if(qnum  == 0){
		document.getElementById("b1").disabled=true
	}
	document.getElementById("b2").disabled=false
}


function showQuestion() {
	if(!feedbackA1)
		document.getElementById("b3").disabled=true
	else document.getElementById("b3").disabled=false
	
	document.getElementById("feedback").innerHTML=""
	
	//var hint=	qxml.getElementsByTagName("hint")[0]
	//if(hint) alert("there is a hint " + hint.firstChild.nodeValue)
		
	currentQuestion= qxml.getElementsByTagName("question")[qnum]
	//var hint=	currentQuestion.getElementsByTagName("hint")[0]
	
	// If there is more than one q tag then one is chosen at random.
	qs= currentQuestion.getElementsByTagName("q")
	index = Math.floor(qs.length*Math.random())
	//alert(index)
	q=qs[index]
	
	
	
	questionType = currentQuestion.getAttribute('type')

		
	html = "<p class= \"question\"><b>Question " + (qnum+1) + " out of " + numberOfQuestions + ".</b><br>" 
	
	html += q.firstChild.nodeValue  + "<br><br>"
	imageLength = currentQuestion.getElementsByTagName("imageURL").length
	if (imageLength !=0) {
		
		
		imageURL = currentQuestion.getElementsByTagName("imageURL")[0].firstChild.nodeValue
		html += "<img src=\"" + imageURL + "\"> <br>" 
		//alert(imageURL)
	}
	var numericFocus = false
	switch(questionType) {
		
	//if(questionType == "sc" || questionType == "mc") {
		case "mc":
		case"sc":
			if(questionType == "sc") buttonType = "radio"
				else buttonType = "checkbox"
				
		 // ctexts = currentQuestion.getElementsByTagName("ctext")
		  choices = currentQuestion.getElementsByTagName("choice")
		  //correct =currentQuestion.getElementsByTagName("correct")
		  nChoices = choices.length
		  //alert ("question number " + qnum + ", number of choices =  " + nChoices)
		  for (i=0;i<nChoices; i++) {
		  //alert(choices[i].getElementsByTagName("cfeedback").length)
		  	  aChoice = choices[i]
			  //alert(i + " " + aChoice.getElementsByTagName("correct").length)
			  //isItCorrect = correct[i].firstChild.nodeValue
			  isItCorrect = aChoice.getElementsByTagName("correct")[0].firstChild.nodeValue
			  //ctext=ctexts[i]
			  ctexts = aChoice.getElementsByTagName("ctext")
			  index = Math.floor(ctexts.length*Math.random())
			  ctext = ctexts[index]
			  b="<input type = \"" + buttonType + "\" name = \"rrr\"" + "\ value = \"" + isItCorrect + "\" id = \"" + i + "\"> "
			
		  //alert(i + " " + choices + " " + b)
			  html+= b + ctext.firstChild.nodeValue + "<br><br>"
		  }
		  
		  if(qs.length == 1 && ctexts.length == 1)
			document.getElementById('similar').style.visibility='hidden';
		  else 
			document.getElementById('similar').style.visibility='visible';
	  //}
	  //else if (questionType =="fixNumeric") {
		  break
		case "numeric" :
		case "fixNumeric":
			document.getElementById('similar').style.visibility='hidden';
			numericFocus = true
		  //nd = normal_deviates(50, 10, 8)
		  //alert(nd)
		  html+= "<input  type=\"text\"  id=\"numeric\"> "	
		  datainfo = currentQuestion.getElementsByTagName("datainfo")
			  if(datainfo.length == 0) break
				  dsID = datainfo[0].getAttribute("dsID")
				  data = qxml.getElementsByTagName("dataset")
				  //alert(data.length)
				  for(i=0;i<data.length;i++) {
					  //alert(data[i].getAttribute("dsID") + " " + dsID)
					  if(data[i].getAttribute("dsID") == dsID){
						 // output = ""
						 output = "<pre>"
						  variables  = data[i].getElementsByTagName("variable")
						  dArrays = new Array(variables.length)
						   L = new Array(variables.length)
						   
		// all variables are displayed and the vname parameter is ignored.
						 
							  for (j=0;j<variables.length;j++) {
								  //vname[j]=variables[j].getAttribute("vname")
								  //alert(vname)
								  output +=variables[j].getAttribute("vname")
								  if(j!=variables.length-1) output+="\t" 
								   //else output += "<br>"
									else output += "\n"
								  d=obs=variables[j].getElementsByTagName("obs")[0].firstChild.nodeValue
									  
								  
								  d2=""
								  last = " "
								  for (k=0;k<d.length;k++) {
								  //for (k=0;k<5;k++) {
									  current = d.charAt(k)
									  if (current != " " || last != " ") {
										  d2+=current
										  last = current
									  }
									  
									  
									  
								  }
								 
								  //alert(d2.split(" "))
								  dArrays[j] = d2.split(" ")
								  L[j] = dArrays[j].length
							  }// end j
					  
					  }
					  
				  }
				  //alert(dArrays[0] + "\n" + dArrays[1])
				  
				  for (j = 0;j<dArrays[0].length;j++) {
					  for (i=0;i<variables.length-1;i++) {
						  //alert(dArrays[0].length + " " + j + " " + i)
					  
						  if( dArrays[i][j] < 10) b= " " 
						  		else b= ""
							
							if( dArrays[i][j] >=0) b+= " "
						  		output+= b + dArrays[i][j] + "\t"
						  
					  }
					  
					 if( dArrays[i][j] < 10) b= " " 
						  	else b= ""
							
						if( dArrays[i][j] >=0) b+= " "
					 
					 // alert(output)
					 output+= b + dArrays[variables.length-1][j]
					  //alert(output)
					 // output +="<br>"
					   output += "\n"
				  }
				 
				//alert(output)
				//html += "<br>" + output
				html +=  output +"</pre> <br>"
				break
			//}
		case "disNumeric":
		numericFocus=true
					document.getElementById('similar').style.visibility='visible';

			html+= "<input  type=\"text\"  id=\"numeric\">"
			
		  	datainfo = currentQuestion.getElementsByTagName("datainfo")
			
			dsID = datainfo[0].getAttribute("dsID")
			data = qxml.getElementsByTagName("dataset")
				  //alert(data.length)
			
			for(i=0;i<data.length;i++) {
					  //alert(data[i].getAttribute("dsID") + " " + dsID)
				if(data[i].getAttribute("dsID") == dsID){
					output = "<pre>"
					//output = ""
					distributions=data[i].getElementsByTagName("distribution")
					nDist = distributions.length
					vnames = new Array(nDist)
					dArrays = new Array(nDist)
					
				  for (j=0;j<nDist;j++) {
					  		dname =  distributions[j].getElementsByTagName("dname")[0].firstChild.nodeValue
							//alert(dname)
					  		vnames [j] = distributions[j].getAttribute("vname")
							//alert(vnames[j])
						  //alert(distributions[j].getAttribute("vname"))
						  params=distributions[j].getElementsByTagName("parameter")
						  for (k=0;k<params.length;k++) {
							  switch (params[k].getAttribute("pname")) {
								  case "decimal":
									  decimal=parseInt(params[k].getAttribute("pvalue"))
									  break
								  case "mean":
									  mean=parseFloat(params[k].getAttribute("pvalue"))
									  break
								  case "sd":
									  sd=parseFloat(params[k].getAttribute("pvalue"))
								  case "m1":
									  m1=parseFloat(params[k].getAttribute("pvalue"))
									  
									  
									  break
								  case "sd1":
									  sd1=parseFloat(params[k].getAttribute("pvalue"))
									  break
								  case "m2":
									  m2=parseFloat(params[k].getAttribute("pvalue"))
									  break
								 case "sd2":
									  sd2=parseFloat(params[k].getAttribute("pvalue"))
									  break
								  case "r":
									  r=parseFloat(params[k].getAttribute("pvalue"))
									  break
								
								  
						  		}
							  
				   			}
							  //alert( " m2 = " + m2 + " sd2 = " + sd2 + "r= " + r)
						n = parseInt(distributions[j].getElementsByTagName("sampleSize")[0].firstChild.nodeValue)
						//alert (mean + " " + sd + " " + decimal)
						biv = false
						switch (dname) {
							case "normal": 
								dArrays[j]=normal_deviates(mean, sd, n)
								break
							case "Bivariable":
								biv = true
						}
						//dArrays[j]=normal_deviates(mean, sd, n, decimal)
							
					} //end j
					n=distributions[0].getElementsByTagName("sampleSize")[0].firstChild.nodeValue
					if (!biv) {
						for (j=0;j<nDist-1;j++) {
							output += "  " + distributions[j].getAttribute("vname") + "\t"						
							
						}
						
						output += "  " + distributions[nDist-1].getAttribute("vname") + "\n"
					}
					else {
						vname = distributions[0].getAttribute("vname").split("_")
						
						output += vname[0] +  "\t"	+vname[1] + "\n"
						//alert(output)
						dArrays = gen_Bivariate(n,r,m1,m2,sd1,sd2)
						nDist=2
						//alert("dArrays = " + dArrays[0] + "\n" + dArrays[1])
						
					}

					// assumes equal n
					
					for (k=0;k<n;k++) {
						
						for (j=0;j<nDist-1;j++) {
							//alert(j + " " + k)
							if (Math.abs(dArrays[j][k]) < 10) b=" "
								else b=""
								
						 	if (dArrays[j][k] >= 0) b+=" " 
							
							
							output += b + dArrays[j][k].toFixed(decimal)+ "\t"
							//output += dArrays[j][k] + "\t"
							
						}
				
						if (Math.abs(dArrays[j][k]) < 10) b=" "
								else b=""
								
						 	if (dArrays[j][k] >= 0) b+=" " 
						
						output += b + dArrays[nDist-1][k].toFixed(decimal) + "\n"
						//output += dArrays[nDist-1][k] + "<br>\n"
					}
					output +="</pre>"
					//alert(output)
					html +=  output
				
				} // end if
			} // end i
			
		
	} // end switch

	
	while (html.indexOf("lfxx") != -1)
		html=html.replace(/lfxx/,"<br>") 
		
	while (html.indexOf("^2") != -1)
		html=html.replace(/\u005e2/,"<sup>2</sup>")	
		
	while (html.indexOf(" mu ") != -1)
		html=html.replace(/ mu /," &mu; ")
		
	while (html.indexOf("_subscrX_") != -1)
		html=html.replace(/_subscrX_/,"<sub>")
		
		
	while (html.indexOf("_subscrY_") != -1)
		html=html.replace(/_subscrY_/,"</sub>")
	
	while (html.indexOf("etasquared") != -1)
		html=html.replace(/etasquared/,"&eta;<sup>2</sup>")
		
	while (html.indexOf("omegasquared") != -1)
		html=html.replace(/omegasquared/,"&omega;<sup>2</sup>")
		
	while (html.indexOf("_pi_") != -1)
		html=html.replace(/_pi_/,"&pi;")

	
	//html=html.replace(/%gt%/,">")
	html+="</p>"


	document.getElementById("display").innerHTML=html
	
	//if(numericFocus) document.getElementById('numeric').focus()
	/*q0choice = q0.getElementsByTagName("choice")
	numChoices = q0
	
	
	//ch0 = q0choice[0]
	correct = ch0.getElementsByTagName("correct")
	chText= ch0.getElementsByTagName("ctext")
	*/
	
	
}

function GetXmlHttpObject() {
  if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
		return new XMLHttpRequest();
  }
  else if (window.ActiveXObject) {
	// code for IE6, IE5
	return new ActiveXObject("Microsoft.XMLHTTP");
  }
  else return null;
}

function checkAnswers() {
	//alert(tryNumber)
	tryNumber++
	//output += tTest(dArrays[0], dArrays[1]) + "\n<br>"
	cfeedback=""
	OK = true
	

	fb = currentQuestion.getElementsByTagName("feedback")
	if (fb.length == 0) feedback01 = "No explanation available. "
	else if (!feedbackA1) feedback01 = noFeedback 
		else feedback01= fb[0].firstChild.nodeValue

		switch(questionType) {
			case "sc":
			case "mc":

			  for (i=0;i<nChoices;i++) {
				  choice = document.getElementById(i + "")
				  if (choice.value == "true") chosen = true
					  else chosen = false
					  
				  if (chosen != choice.checked) {
					  if(choices[i].getElementsByTagName("cfeedback").length !=0)
						cfeedback+=choices[i].getElementsByTagName("cfeedback")[0].firstChild.nodeValue + "<br><br>"
				
					
					 if(choices[i].getElementsByTagName("hint").length !=0)
						feedback01="Hint: " + currentQuestion.getElementsByTagName("hint")[0].firstChild.nodeValue
					
					
					  OK=false
					
				  } 
				}
		
			break
		  case "numeric":
		  case "fixNumeric":
		
				
			
			
		
			r = document.getElementById("numeric").value
			r=r.replace(/%/,"")
			answer = currentQuestion.getElementsByTagName("value")[0].firstChild.nodeValue
			
			
			tolerance = currentQuestion.getElementsByTagName("tolerance")[0].firstChild.nodeValue
			signCounts= currentQuestion.getElementsByTagName("sign")
			sign_counts=true
			if (signCounts.length !=0)
				if(signCounts[0].firstChild.nodeValue == "no")  sign_counts = false
					
			
			if (!sign_counts) {
				r= Math.abs(r)
				answer = Math.abs(answer)
			}
			error = Math.abs(r-answer)
			if(error <= tolerance) OK = true
			else OK = false 
			if(tryNumber==1 && !OK)
				if(currentQuestion.getElementsByTagName("hint").length != 0)
					feedback01="Hint: " + currentQuestion.getElementsByTagName("hint")[0].firstChild.nodeValue
			//alert(answer + " " + tolerance + " " + r + " " + error)
			break
		
		case "disNumeric": 
			r = document.getElementById("numeric").value
			if (r== "") r = -55000.1
			stat = currentQuestion.getElementsByTagName("answer")[0].getAttribute("stat")
			switch (stat) {
				case "Ind_T_test":	
	
				answer = tTest(dArrays[0], dArrays[1])
	
				error = Math.abs(Math.abs(answer)-Math.abs(r))
				//answer = Math.round(10000*answer)/10000
				answer = "t = " + answer.toFixed(4)
	
				break
				
				case "p75":
				case "p25":
				if (stat=="p25") p=.25
					else p = .75
				
				index = getDataIndex(vnames, currentQuestion)
									 
				
					// if(vnames[i] == currentQuestion.getElementsByTagName("vname")[0]
			
				answer = percentile(p,dArrays[index])
			
				error = Math.abs(answer - r)
				break
				
				case "sd":
				  index = getDataIndex(vnames, currentQuestion)
				  answer = mean_sd(dArrays[index])[1]
				  error = Math.abs(r-answer)
				  answer = answer.toFixed(4)

				break
				case "correlation":
				  
				  answer = Pearson(dArrays[0], dArrays[1])
				  error = Math.abs(Math.abs(answer)-Math.abs(r))
				  //alert(r + " " + answer + " " + error)
				  answer = answer.toFixed(4)
				break
				
				case "regression":
				  
				  corr = Pearson(dArrays[0], dArrays[1])
				  sdy = mean_sd(dArrays[1])[1]
				  sdx = mean_sd(dArrays[0])[1]
				  answer = corr*sdy/sdx
				  error = Math.abs(answer-r)
				  //alert(r + " " + answer + " " + error)
				  answer = answer.toFixed(4)
				break
				
				case "T_test":
					//N = dArrays[0].length
					//alert(dArrays[0])
					
					answer = Math.abs(related_t(dArrays[0], dArrays[1]))
					error = Math.abs(Math.abs(answer)-Math.abs(r))
					answer = answer.toFixed(4)					
	
				break
				
				case "singlesample_t":
					if (currentQuestion.getElementsByTagName("altH").length >0)
						alternate_h = currentQuestion.getElementsByTagName("altH")[0].firstChild.nodeValue
					else alternate_h=0
					
					
					index = getDataIndex(vnames, currentQuestion)	
					answer =singleSample_t(dArrays[index], alternate_h)
					error = Math.abs(Math.abs(answer)-Math.abs(r))
					answer = answer.toFixed(4)			
				
				break
				
				case "singlesample_p":
					if (currentQuestion.getElementsByTagName("altH").length >0)
						alternate_h = currentQuestion.getElementsByTagName("altH")[0].firstChild.nodeValue
					else alternate_h=0
					
					
					index = getDataIndex(vnames, currentQuestion)	
					F = Math.pow(singleSample_t(dArrays[index], alternate_h),2)
					dfe = dArrays[index].length -1
					answer = probF(F,1,dfe)
					error = Math.abs(answer-(r))
					answer = answer.toFixed(4)				
				
				
				
				break
				
				case "F_test":
					answer = anova(dArrays)
					error = Math.abs(answer-(r))
					answer = answer.toFixed(4)						
				
				break
				
				case "F_test_p":
					k = dArrays.length
					var n = dArrays[0].length
					F = anova(dArrays)
					answer = probF(F,k-1, k*n-k)
					error = Math.abs(answer-(r))
					answer = answer.toFixed(4)						
				
				break
				case "repeatAnova_Ftrial":
					answer=Math.round(10000*repeatAnova(dArrays))/10000	
					error = Math.abs(answer-(r))		

			} // end stat switch
		tolerance = currentQuestion.getElementsByTagName("tolerance")[0].firstChild.nodeValue
		feedback01 = feedback01.replace(/showCorrectAnswer/, answer)
		  
		
		
		
	
		if(error <= tolerance) OK = true
			else OK = false 	
	} // end switch
	
		
	if (OK) theSrc = "correct.gif"
		else theSrc = "incorrect.gif"
		
	dHTML= "<img src=\"" + theSrc + "\" width=\"38\" height = \"23\"> <br>"
	
	if (cfeedback !="") feedback01= cfeedback
	
	while (feedback01.indexOf("^2") != -1)
		feedback01=feedback01.replace(/\u005e2/,"<sup>2</sup>") 
		
		while (feedback01.indexOf("_pi_") != -1)
		feedback01=feedback01.replace("_pi_","&pi;")
		
		 
	while (feedback01.indexOf("qqq") != -1)		
	feedback01=feedback01.replace(/qqq/,"&quot;")	
	//<img src="../correct.gif" alt="correct" name="icon" width="38" height="23" id="icon">
	dHTML += feedback01 
	//if (cfeedback !="") dHTML += "<br><br> " + cfeedback
	dHTML = "<p class=\"question\">" +dHTML + "</p>"
	//alert(dHTML)
	//if(feedbackA1)
		document.getElementById("feedback").innerHTML=dHTML
	//window.scroll(0,window.innerHeight);
	if(qnum + 1 == numberOfQuestions) feedbackA1=true
	//alert(window.innerHeight)
	//document.getElementById("feedback").style.visibility="visible"
	//alert(window.pageYOffset)
	//if(window.pageYOffset >0)
	var scrollPosition
	if (navigator.appName == 'Microsoft Internet Explorer')
		scrollPosition = document.body.scrollTop
	else 
		scrollPosition = window.pageYOffset
	
	window.scrollTo(0, scrollPosition+500)
	return false;
}

function normal_deviates(m, sd, n) {
	//alert("normal deviated " + m + " " + sd + " " + n)
	 var x = 0, y = 0, rds, c;
	 rfact = Math.pow(10,decimal)
	 
	if (n%2 !=0) nn=n+1
		else nn=n
	
	random_numbers = new Array(n)
	count = 0
	for (i=0;i<nn/2;i++) {
 
  		do {
   	 		x = Math.random()*2-1;
    		y = Math.random()*2-1;
   		 	rds = x*x + y*y;
  		}
 		while (rds == 0 || rds > 1)
  			c = Math.sqrt(-2*Math.log(rds)/rds);
			
			
		
	m=parseFloat(m)
		random_numbers[count]=x*c*sd + m
		random_numbers[count] = Math.round(rfact*random_numbers[count])/rfact
		count++
		if (count > n-1) break
		random_numbers[count]=y*c *sd + m
		random_numbers[count] = Math.round(rfact*random_numbers[count])/rfact
		count++
	}
	
  return random_numbers
}

function mean_sd (y) {
		s=0
		ssq=0
		n= y.length
		for (i=0;i<n;i++) {
			s+=y[i]
			ssq+=y[i]*y[i]
		}
		m=s/n
		sd = Math.sqrt((ssq-m*s)/(n-1))
		return new Array(m,sd)
}

function tTest(x1,x2) {
	//assumes equal n
	
	g1=mean_sd(x1)
	g2=mean_sd(x2)
	n = x1.length
	MSE = (g1[1]*g1[1] + g2[1]*g2[1])/2
	se=Math.sqrt(2*MSE/n)
	t=(g1[0]-g2[0])/se
	return t
}
function gen_Bivariate(N,r,m1,m2,sd1,sd2) {
	if(r==0) {
		ya=  normal_deviates(m1, sd1, N)
		yb=  normal_deviates(m2, sd2, N)
	}
	else {
		  if (r>=0)  theSign=1; else theSign=-1;
		  
		  ya=  normal_deviates(m1, sd1, N)
	  
		  sda = mean_sd(ya)[1]
		  //alert(sda + " " + r + "seEst = " + seEst)
		  seEst = sda*Math.sqrt((1-r*r)/(r*r))
		  yb = normal_deviates(0,seEst,N)
		  //adjust = sd2/ Math.sqrt(sd1*sd1+seEst*seEst)
		  sdx=mean_sd(yb)[1]
		  adjust = sd2/Math.sqrt(seEst*seEst + sda*sda)
		  
		  mAdjust = m2-adjust*m1
		  
		  for (var i=0;i<N;i++) {
			  yb[i]+=ya[i]
			  yb[i]=Math.round(yb[i]*adjust + mAdjust)	
		  }
		  if(theSign <0) 
			  for (var i=0;i<N;i++){
				 Math.round( yb[i]=2*m2-yb[i])
			  }
	}
	return new Array(ya,yb);

}

function percentile (p, x)


	{
		/*x = new Array(3,5,7,8,9,11,13,15)
		x.sort(function(a,b){return a - b})
		
		p=.25
		*/
		var n = x.length
		
		x.sort(function(a,b){return a - b})
		var R = p*(n+1);
		IR = Math.floor(R);
		FR = R - Math.floor(R)
		
		if (IR==0)
			ptl = x[0];
		else if (IR>=n)
			ptl = x[n-1];
		else
			ptl= x[IR-1] + FR*(x[IR]-x[IR-1]);
			
	
		
		return ptl
	}		
function getDataIndex(vnames,currentQuestion) {

				var theVariable
				//alert(currentQuestion.getElementsByTagName("ansvar").length)
				if (currentQuestion.getElementsByTagName("ansvar").length > 0)
					theVariable = currentQuestion.getElementsByTagName("ansvar")[0].getAttribute("vname")
						else theVariable = 0
				var index = 0
				for (i=0;i<vnames.length;i++) {
					if(vnames[i] == theVariable) {
						index = i
						
						break
					  }
				}
		return index
}

function Pearson (X,Y) {
	sx=0;sxx=0;sy=0;syy=0;sxy=0
	var pr
	N = X.length
	for (i=0;i<N;i++) {
		sx+=X[i]
		sy+=Y[i]
		sxx+=X[i]*X[i]
		syy+=Y[i]*Y[i]
		sxy +=X[i]*Y[i]	
	}
	pr = (sxy-sx*sy/N)/Math.sqrt((sxx-sx*sx/N)*(syy-sy*sy/N))
	return pr
}
function related_t (y1,y2) {
	N= y1.length
	diff = new Array(N)
	for (i=0;i<N;i++) {
		diff[i] = y2[i]-y1[i]
	}
	temp = mean_sd(diff)
	sem = temp[1]/Math.sqrt(N)
	t =temp[0]/sem
	return t
	
}

function singleSample_t(y, h1) {
	N= y.length
	m_sd = mean_sd(y)
	t = (m_sd[0]-h1)/(m_sd[1]/Math.sqrt(n))
	return t
	
	
}
function anova(data) {
	k= data.length
	n = data[0].length // equal n assumed
	means = new Array(k)
	variances = new Array(k)
	for (var i=0;i<k;i++) {
		temp = mean_sd(data[i])
		means[i]=temp[0]
		variances[i] = Math.pow(temp[1],2)
	}
	
	MSB = n * Math.pow(mean_sd(means)[1],2)
	MSE = mean_sd(variances)[0]
	F = MSB/MSE
	return F
	
	
}

function repeatAnova(data) {
	
	var N= data[0].length
	var k=data.length
	//alert(N + " " + k)
	var totals = new Array(k)
	var subs=new Array(N)
	for (var i=0;i<N;i++)
		subs[i]=0
		
	var SST=0, GT=0, x, SSQsub=0
	for (var i=0;i<k;i++) {
		totals[i]=0
		for (var j=0;j<N;j++) {
			
			x = data[i][j]
			subs[j]+=x
			//alert(x)
			totals[i] += x
			SST += x*x
			GT+=x
			
		}
		
	}
	var CF = GT*GT/(N*k)
	var SSTrials=0
	for (var i=0;i<k;i++) {
		SSTrials+=totals[i]*totals[i]
		
	}
	SSTrials=SSTrials/N-CF
	SST=SST-CF
	
	for (var i=0;i<N;i++)
		SSQsub+= subs[i]*subs[i]
	
	SSQsub= SSQsub/k - CF
	
	var SSE = SST-SSTrials-SSQsub
	//alert(totals + " " + CF +  "\n" + SST + " " + SSTrials + " " + " " + SSQsub + " " + SSE)
	var MSTrials = SSTrials/(k-1)
	var MSE = SSE/((N-1)*(k-1))
	var F = MSTrials/MSE
	//alert(F)
	return F
	
	
}
		
	function probF(fr, dn,dd) {

		var f = fr;
		var a = dn;
		var b = dd;
		var iv=0;
		var fp;
		if (Math.floor(a/2) * 2 == a) {
			//even numerator df
			fp = L401(a,f,b,iv);
			return fp;
		}

		else if (Math.floor(b/2) * 2 != b) {
			fp = L504(a,f,b,iv);
			return fp;
		}
		else {
			f=1/f;
			a=dd;
			b=dn;
			iv=1;
			fp = L401(a,f,b,iv);
		
			return fp;
		}

}




function L504( a, f, b, iv) {
	var q = a*f/(a*f+b);
	var sa = Math.sqrt(q);
	var sl = Math.log(sa);
	var ca = Math.sqrt(1-q);
	var cl = Math.log(ca);
	var al = Math.atan(sa/Math.sqrt(-sa*sa+1));
	var fp = 1-2*al/Math.PI;
	var r=0;
	var c;
	var n;
	if (b!=1) {
		c = Math.log(2*sa/Math.PI);
		fp-=Math.exp(c+cl);
		if (b!=3) {
			 n =  Math.floor((b-3)/2);
			for (var i=1;i<=n;i++) {
				var x =  (2*i+1);
				r+=Math.log((x-1)/x);
				var rr=r+cl*x+c;
				if (rr>-78.4) {
					fp-=Math.exp(rr);
				}
			}
		}
	}
	
	if (a!=1) {
		 c = r;
		
		if (b>1) {
			c+=Math.log(b-1);
		}
		
		c+=Math.log(2/Math.PI) + sl + cl*b;
		
		if (c>-78.4) {fp+=Math.exp(c);}
		
		if (a!=3) {
			 n = Math.floor((a-3)/2);
			r=0;
			for (var i=1;i<=n;i++) {
				var x=  (i*2+1);
				r+=Math.log((b+x-2)/x);
				var rr=r+sl*(x-1)+c;
				if (rr>-78.4) {fp+=Math.exp(rr);}
			}
		}
	}	
	return fp;
	
}



function L401( a, f, b, iv) {

			var q = a*f/(a*f+b);
			var ql=Math.log(q);
			var fp=0;
			var c = Math.log(1-q)*b/2;
			var n;
			if (c>-78.4) {
				fp = Math.exp(c);
			}
			
			if (a != 2) {
			 n = Math.floor(a/2-1);
				var r=0;
				for (var i=1;i<=n;i++) {
					var x= (2*i);
					r+=Math.log(b+x-2)-Math.log(x) + ql;
					if (r+c> -78.4) {
						fp+=Math.exp(r+c);
					}
				 }
				}
				
				if (iv==1) {
					fp = 1-fp;
				}

			return fp;
}

		
		
		

