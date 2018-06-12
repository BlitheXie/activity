var saveSelectColor = {
    'Name': 'SelcetColor',
    'Color': 'theme-white'
}



// 判断用户是否已有自己选择的模板风格
if (storageLoad('SelcetColor')) {
    $('body').attr('class', storageLoad('SelcetColor').Color)
} else {
    storageSave(saveSelectColor);
    $('body').attr('class', 'theme-white')
}


// 本地缓存