const watchedMenu = document.getElementById("watchedMenu");
const modalOverlay = document.getElementById("modalOverlay");
const nav = document.getElementsByClassName("nav");
const modal = document.getElementsByClassName("modal");


watchedMenu.addEventListener("click", function(){
    modalOverlay.style.display = "flex";
    nav[0].style.display = "none";

})


modalOverlay.addEventListener("click", e => {
    const evTarget = e.target
    if(evTarget.classList.contains("modal")) {
        modalOverlay.style.display = "none"
       
    }
    nav[0].style.display = "flex";
})


