"use strict";
let btn_1 = document.querySelector("#ti_1");
let btn_2 = document.querySelector("#ti_2");
let btn_3 = document.querySelector("#ti_3");
const app = document.querySelector("#app");

let leftOffset = 0;

btn_1.addEventListener("click", () => {
  if (leftOffset === 600) leftOffset = -100;
  app.style.cssText = `margin-left:${(leftOffset += 100)}px;
  transition: margin 2s;`;
});

btn_2.addEventListener("click", () => {
  app.style.cssText = `animation: btn_2 5s `;
  setTimeout(() => {
    app.style.cssText = ``;
  }, 5500);
});

btn_3.addEventListener("click", () => {
  app.style.cssText = `animation: btn_3 5s infinite`;
});
