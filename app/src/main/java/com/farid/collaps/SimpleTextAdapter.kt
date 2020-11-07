package com.farid.collaps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import github.hellocsl.cursorwheel.CursorWheelLayout.CycleWheelAdapter
import kotlinx.android.synthetic.main.wheel_image_layout.view.*
import java.util.zip.Inflater

class SimpleTextAdapter constructor(
    _context: Context,
    _menuItemData: List<MenuItemData>
) : CycleWheelAdapter() {

    var context: Context = _context
    var menuItemData = _menuItemData
    var layoutInflater = LayoutInflater.from(context)


    override fun getCount(): Int {
        return menuItemData.size
    }

    override fun getView(parent: View, position: Int): View {

        val data = getItem(position)
        val root = layoutInflater.inflate(R.layout.wheel_image_layout, null, false)
        var imageView = root.iv_picker

        imageView.setImageResource(data.imageResourse)

        return root
    }

    override fun getItem(position: Int): MenuItemData {
        return menuItemData.get(position)
    }
}