let Dheader = document.getElementsByClassName("Dheader");
let iframe = document.getElementById("iframe");
for(let i=0; i<Dheader.length; i++){
	Dheader[i].addEventListener('click',function(){
		if(i == 0)iframe.src = 'useInformationBoard?condition=rentHistory';
		else if(i == 1)iframe.src = 'useInformationBoard?condition=borrow';
		else if(i == 2)iframe.src = 'useInformationBoard?condition=reserve';
		else iframe.src = 'useInformationBoard?condition=interest';
	});
}

