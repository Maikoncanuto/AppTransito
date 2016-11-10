App.factory('AgenteService', function($http, API){
	return {
		list: function(){
			return $http.get(API+'agente').then(getResposta).catch(getErro);
			
			function getResposta(data){
				console.log(data);
			};
			
			function getErro(data){
				console.log(data);
			};
			
		},
		
		create: function(item){
			return $http.post(API+'agente', item).then(getResposta).catch(getErro);
			
			function getResposta(data){
				console.log(data);
			};
			
			function getErro(data){
				console.log(data);
			};
			
		},
		
		update: function(item, id){
			return $http.put(API+'agente/'+id, item).then(getResposta).catch(getErro);
			
			function getResposta(data){
				console.log(data);
			};
			
			function getErro(data){
				console.log(data);
			};	
		},
		
		
		delete: function(id){
			return $http.delete(API+'agente/'+id).then(getResposta).catch(getErro);
			
			function getResposta(data){
				console.log(data);
			};
			
			function getErro(data){
				console.log(data);
			};
		}
	}
})