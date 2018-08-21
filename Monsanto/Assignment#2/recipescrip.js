var baseUrl = "http://localhost:8080/"
    var app = angular.module("myApp",[]);
    app.controller('myCtrl', function($scope,$http){

    	$scope.item1="";
    	$scope.item2="";
    	$scope.item3="";	
    	$scope.item4="";
    	$scope.recipename="";
    	$scope.selectedRecipe=""
    	$scope.recipeListFromDB=[];

    	fetch(baseUrl+"read",{
    		method:"GET",
    		headers:{'Authorization':localStorage.getItem("token"),'Content-Type': 'application/json'}
    	}).then(function(response){
    		if(response.status==200){
    			var temp = new Array();
    			response.json().then(function(data){
    				for(var l=0;l<data.length;l++){
    					var fieldrecipe= response.data[l].listofRecipe;
    					temp.push(fieldrecipe);
    					//$scope.selectedRecipe=response.data.listofRecipe;
    				}
    				$scope.recipeListFromDB=temp;
    			});
    		}
    	});
    	

    	$scope.recipeSubmit = function(argument) {
    		var paramString = '';
    		paramString += 'recipename=' + $scope.recipename;
    		paramString += '&item1=' + $scope.item1;
    		paramString += '&item2=' +$scope.item2;
			paramString += '&item3=' + $scope.item3
			paramString += '&item4=' + $scope.item4			
			console.log(paramString)
			//$http.get(baseUrl+'save?' +paramString)
			fetch(baseUrl+'save?' +paramString, {
			method: 'POST',
			body:JSON.stringify({

				 recipename: $scope.recipename,
    		 	 item1: $scope.item1,
    		 	 item2: $scope.item2,
				 item3: $scope.item3,
			 	 item4:$scope.item4			
			}),
			headers:{'Authorization':"hii",'Content-Type': 'application/json'}
			}).then(function(response) {
				if(response.status === 200){
					response.json().then(function(data){
						console.log(data);
						document.getElementById('titlerecipe').style.display = 'none';
    			   		document.getElementById('recipeListId').style.display = 'block';
    			   		document.getElementById('addRecipeListId').style.display = 'none';
					});
				}
    		});
    	}


    	$scope.addNewRecipeListId = function(){
    		document.getElementById('titlerecipe').style.display = 'none';
            document.getElementById('recipeListId').style.display = 'none';
    		document.getElementById('addRecipeListId').style.display = 'block';
    	}
    	 $scope.names= ['DOSA','Biryani','Omlet','Kabab'];

        $scope.recipeList={
            firstRecipe : "OIL",
            secondRecipe : "Dall",
            thirdRecipe : "Rice",
            fourRecipe:"Salt"
            
        };

        $scope.addRecipeList=[];
        jQuery(document).ready(function ()
		{
			jQuery('#selectedNewRecipe').on('change', function () {
				   var selectReip = $("#selectedNewRecipe option:selected").val();
				   $scope.selectedRecipe = selectReip;
				   console.log(selectReip);
				   document.getElementById('titlerecipe').style.display = 'none';
    			   document.getElementById('addRecipeListId').style.display = 'none';
                   document.getElementById('recipeListId').style.display = 'block';
    			   var paramString = "";
    			   paramString= "recipeid="+selectReip;
    			   fetch(baseUrl+"data?"+paramString,{
			    		method:"GET",
			    		headers:{'Authorization':localStorage.getItem("token"),'Content-Type': 'application/json'}
			    	}).then(function(response){
			    		if(response.status==200){
                            $scope.recipeList = response.data;
			    		}
					});	
				});
		});

    });