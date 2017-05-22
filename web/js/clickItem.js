function clickEnMunicipio(id_municipio){
    window.location="http://localhost:8081/Torneos/disciplinas.jsp?id="+id_municipio;
}

function clickEnDisciplina(id_disciplina, id_municipio){
    window.location="http://localhost:8081/Torneos/clubes.jsp?d="+id_disciplina+"&m="+id_municipio;
}
